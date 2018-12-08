package by.pvt.pojo;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.*;

import by.pvt.util.HibernateUtil;

/**
 * @author alve
 */
public class AddressTest {

    @Test
    public void getId() {
        Address address = new Address("Minsk",
                "Stroiteley",
                "5",
                24);

        Session session = HibernateUtil.getInstance().getTestSession();
        session.saveOrUpdate(address);
        assertEquals(1L, address.getId());
        session.delete(address);

        session.close();
    }

}