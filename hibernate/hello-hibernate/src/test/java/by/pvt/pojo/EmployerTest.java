package by.pvt.pojo;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.*;

import by.pvt.util.HibernateUtil;

/**
 * @author alve
 */
public class EmployerTest {

    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void createInstance() {
        Employer employer = new Employer();

        employer.setName("Ivan");
        employer.setCorporatePhoneNumber("37529600100100");

        session.beginTransaction();
        session.saveOrUpdate(employer);
        session.getTransaction().commit();
        assertNotNull(employer);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }
}