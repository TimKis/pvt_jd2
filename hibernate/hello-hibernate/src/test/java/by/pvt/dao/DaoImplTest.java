package by.pvt.dao;

import static org.junit.Assert.*;

import java.io.Serializable;

import org.junit.*;

import by.pvt.pojo.Person;

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
        assertNotNull(dao.load(id));
    }

    @Test
    public void find() {
        assertNull(dao.find(null));
        assertNull(dao.find("testID"));
        Serializable id = dao.saveOrUpdate(new Person()).getId();
        assertNotNull(dao.find(id));
    }


}