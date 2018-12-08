package by.pvt.pojo;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.*;

import by.pvt.util.HibernateUtil;

/**
 * @author alve
 */
public class HeadquarterTest {

    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void createInstance() {
        Headquarter headquarter = new Headquarter();

        headquarter.setCompanyName("OOO Vasilek");
        headquarter.setSiteUrl("www.vasilek.by");
        headquarter.setBankAccount("1212sdsd1212sde23223");
        headquarter.setDirectorName("Director");

        try {
            session.beginTransaction();
            session.saveOrUpdate(headquarter);
            session.getTransaction().commit();
            assertNotNull(headquarter.getId());
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