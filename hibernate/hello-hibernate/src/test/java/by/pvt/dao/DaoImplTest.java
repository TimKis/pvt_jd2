package by.pvt.dao;

import static org.junit.Assert.*;

import java.io.Serializable;

import org.junit.*;

import by.pvt.pojo.Person;
import by.pvt.util.HibernateUtil;

/**
 * @author alve
 */
public class DaoImplTest {

    DaoImpl<Person> dao;

    @Before
    public void setUp() throws Exception {
        dao = new DaoImpl<>(Person.class);
    }

    @After
    public void tearDown() throws Exception {
        dao = null;
    }

    @Test
    public void saveOrUpdate() {
        assertNull(dao.saveOrUpdate(null));

        assertNotNull(dao.saveOrUpdate(new Person()));

        Person person = new Person();
        assertNull(person.getId());
        Person person2 = dao.saveOrUpdate(person);
        assertEquals(person, person2);
        assertNotNull(person.getId());

        person2.setSecondName("Petrova");
        Person person3 = dao.saveOrUpdate(person2);
        assertEquals("Petrova", person3.getSecondName());
    }

    @Test
    public void load() {
        try {
            dao.load(null);
        } catch (Exception e) {
            assertEquals(e.getClass(), IllegalArgumentException.class);
        }

        try {
            dao.load("testID");
        } catch (Exception e) {
            assertEquals(e.getClass(), IllegalStateException.class);
        }

        Serializable id = dao.saveOrUpdate(new Person()).getId();
        Person loadedPerson = dao.load(id);
        assertNotNull(loadedPerson);
        assertNotNull(loadedPerson.getId());
        assertEquals(id, loadedPerson.getId());
    }

    @Test
    public void find() {
        assertNull(dao.find(null));
        assertNull(dao.find("testID"));
        Serializable id = dao.saveOrUpdate(new Person()).getId();
        assertNotNull(dao.find(id));
    }

    @Test
    public void updateName() {
        Person person = new Person();
        person.setName("Vasia");
        person.setSecondName("Ivanov");
        person = dao.saveOrUpdate(person);
        assertNotNull(person.getId());
        assertEquals(person.getName(), "Vasia");

        System.out.println("contains(person): " + HibernateUtil.getInstance().getSession().contains(person));
        //person POJO is connected with current session
        dao.updateName(person.getId(), "Petia");
        assertEquals(person.getName(), "Petia");
    }


    @Test
    public void updateNameWithExceptionAndRollback() {
        Person person = new Person();
        person.setName("Vasia");
        person.setSecondName("Ivanov");
        person = dao.saveOrUpdate(person);
        assertNotNull(person.getId());
        assertEquals(person.getName(), "Vasia");

        // Throws exception, rollbacks transaction and closes session
        dao.updateName(null, null);

        System.out.println("contains(person): " + HibernateUtil.getInstance().getSession().contains(person));
        //person POJO is disconnected from session and we need reread it
        person = dao.load(person.getId());
        dao.updateName(person.getId(), "Petia");
        assertEquals(person.getName(), "Petia");
    }


    @Test
    public void delete() {
        Person person = new Person();
        Serializable id = dao.saveOrUpdate(person).getId();
        assertNotNull(id);

        dao.delete(id);
        assertNull(dao.find(id));
        System.out.println(person);
    }
}