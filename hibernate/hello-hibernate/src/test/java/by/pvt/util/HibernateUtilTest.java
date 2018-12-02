package by.pvt.util;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.*;

/**
 * @author alve
 */

public class HibernateUtilTest {


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getInstance() {
        assertNotNull(HibernateUtil.getInstance());
    }

    @Test
    public void getSession() {
        Session session = HibernateUtil.getInstance().getSession();

        assertNotNull(session);
        assertEquals(session, HibernateUtil.getInstance().getSession());
    }


}