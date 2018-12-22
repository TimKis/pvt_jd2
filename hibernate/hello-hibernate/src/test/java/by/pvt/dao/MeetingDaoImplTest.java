package by.pvt.dao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.*;
import org.junit.runners.*;

import by.pvt.pojo.Employee;
import by.pvt.pojo.Meeting;
import by.pvt.pojo.Status;

/**
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MeetingDaoImplTest {

    DaoImpl<Meeting> meetingDao;

    DaoImpl<Employee> employeeDao;

    @Before
    public void setUp() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        meetingDao = new DaoImpl<>(Meeting.class);
        employeeDao = new DaoImpl<>(Employee.class);
        DaoImpl.isTestInstance = true;

        lock.unlock();
    }

    @Test
    public void step1_createInstance() {
        Employee employee1 = createEmployee("1");
        employeeDao.saveOrUpdate(employee1);

        Employee employee2 = createEmployee("2");
        employeeDao.saveOrUpdate(employee2);

        Meeting meeting1 = createMeeting("1");
        meeting1.setAttendees(Set.of(employee1, employee2));
        meeting1.setOrganizer(employee1);
        meetingDao.saveOrUpdate(meeting1);
        assertTrue(meeting1.getId() == 1L);


        Employee employee3 = createEmployee("3");
        employeeDao.saveOrUpdate(employee3);
        Employee employee4 = createEmployee("4");
        employeeDao.saveOrUpdate(employee4);

        Meeting meeting2 = createMeeting("1");
        meeting2.setOrganizer(employee4);
        meeting2.setAttendees(Set.of(employee1, employee2, employee3, employee4));
        meetingDao.saveOrUpdate(meeting2);
        assertTrue(meeting2.getId() == 2L);
    }

    @Test
    public void step3_deleteMeeting() {
        meetingDao.delete(1L);
        meetingDao.delete(2L);
        assertNull(meetingDao.find(1L));
        assertNull(meetingDao.find(2L));

        employeeDao.delete(1L);
        employeeDao.delete(2L);
        employeeDao.delete(3L);
        employeeDao.delete(4L);
        assertNull(employeeDao.find(1L));
        assertNull(employeeDao.find(2L));
        assertNull(employeeDao.find(3L));
        assertNull(employeeDao.find(4L));
    }


    private Meeting createMeeting(String postfix) {
        Meeting meeting = new Meeting();
        meeting.setSubject("Subject" + postfix);
        meeting.setStatus(Status.NEW);
        meeting.setDateTime(Calendar.getInstance().getTime());
        return meeting;
    }

    private Employee createEmployee(String postfix) {
        Employee employee1 = new Employee();
        employee1.setFirstName("First Name" + postfix);
        employee1.setLastName("Last Name" + postfix);
        return employee1;
    }

    public void tearDown() {
        DaoImpl.isTestInstance = false;
    }
}
