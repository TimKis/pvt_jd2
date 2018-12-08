package by.pvt.pojo;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.junit.*;

import by.pvt.util.HibernateUtil;

/**
 * @author alve
 */
public class WorkerTest {

    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void createInstance() {
        Worker worker = new Worker();
        worker.setName("Worker");
        worker.setSecondName("Worker2");
        worker.setCompanyName("OOO Romashka");
        worker.setSalary(BigDecimal.valueOf(1200.00));

        try {
            session.beginTransaction();
            session.saveOrUpdate(worker);
            session.getTransaction().commit();
            assertNotNull(worker.getId());
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