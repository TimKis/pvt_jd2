package by.pvt.dao;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.*;
import org.junit.runners.*;

import by.pvt.pojo.User;
import by.pvt.pojo.UserDetails;

/**
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoImplTest {

    DaoImpl<User> userDao;

    @Before
    public void setUp() {
        userDao = new DaoImpl<>(User.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_creatNewUser() {
        User user = new User();
        user.setUserName("User");
        user.setUserEmail("mail@mail.ru");

        UserDetails userDetails = new UserDetails();
        userDetails.setPassword("password");
        userDetails.setLoginAttempts(3);
        userDetails.setExpiredDate(new Timestamp(System.currentTimeMillis()));

        user.setUserDetails(userDetails);
        userDetails.setUser(user);

        userDao.saveOrUpdate(user);

        assertTrue(user.getId() > 0);
    }


    @Test
    public void step2_findUser() {
        User user = userDao.find(1L);
        assertNotNull(user);
        assertNotNull(user.getUserDetails());
        System.out.println(user.getUserEmail() + " " + user.getUserName());
    }

    @Test
    public void step3_updateUser() {
        User user = userDao.load(1L);
        assertTrue("User".equals(user.getUserName()));
        assertTrue("password".equals(user.getUserDetails().getPassword()));
        user.setUserName("New_User");
        user.getUserDetails().setPassword("New_password");

        userDao.saveOrUpdate(user);

        User user2 = userDao.load(1L);
        assertTrue(user2.getUserName().equals("New_User"));
        assertTrue("New_password".equals(user2.getUserDetails().getPassword()));

    }

    @Test
    public void step4_deleteUser() {
        User user = userDao.load(1L);

        userDao.delete(user.getId());

        User user2 = userDao.find(1L);

        assertNull(user2);
    }

    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        userDao = null;
    }

}
