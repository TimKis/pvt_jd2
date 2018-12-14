package by.pvt.pojo;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.*;

import by.pvt.util.HibernateUtil;

/**
 * @author alve
 */
public class AddressTest {

    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void getId() {
        Address address = new Address("Minsk",
                "Stroiteley",
                "5",
                24);

        try {
            session.beginTransaction();
            session.saveOrUpdate(address);
            assertTrue(address.getId() > 0);
            session.delete(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @After
    public void tearDown() throws Exception {
        if(session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }

}