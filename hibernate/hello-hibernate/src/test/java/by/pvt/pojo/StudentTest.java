package by.pvt.pojo;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.*;

import by.pvt.util.HibernateUtil;

/**
 * @author alve
 */
public class StudentTest {

    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }


    @Test
    public void createInstance() {
        Student student = new Student();
        student.setName("Shurik");
        student.setUniversity("BSUIR");
        student.setFaculty("KSIS");
        student.setCourseYear((short) 3);

        try {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
            assertNotNull(student.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}