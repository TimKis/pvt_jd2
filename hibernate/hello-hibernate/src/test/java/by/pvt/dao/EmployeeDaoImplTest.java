package by.pvt.dao;

import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;

import java.util.Set;

import org.junit.*;
import org.junit.runners.*;

import by.pvt.pojo.Address;
import by.pvt.pojo.Department;
import by.pvt.pojo.Employee;
import by.pvt.pojo.EmployeeDetails;

/**
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoImplTest {

    DaoImpl<Employee> employeeDao;

    @Before
    public void setUp(){
        employeeDao = new DaoImpl<>(Employee.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_createEmployee() {
        Employee employee1 = new Employee();
        employee1.setFirstName("Name1");
        employee1.setLastName("LastName1");
        employee1.setCellPhone("111111");

        Employee employee2 = new Employee();
        employee2.setFirstName("Name2");
        employee2.setLastName("LastName2");
        employee2.setCellPhone("222222");

        Employee employee3 = new Employee();
        employee3.setFirstName("Name3");
        employee3.setLastName("LastName3");
        employee3.setCellPhone("333333");

        Department department1 = new Department();
        department1.setDepartmentName("Department1");
        department1.setEmployees(Set.of(employee1, employee2));
        //department1.setEmployees(Set.of(employee1));
        employee1.setDepartment(department1);
        employee2.setDepartment(department1);

        Department department2 = new Department();
        department2.setDepartmentName("Department2");
        department2.setEmployees(Set.of(employee3));
        employee3.setDepartment(department2);

        EmployeeDetails employeeDetails1 = new EmployeeDetails();
        Address addres1 = new Address("Minsk", "Lenina", "1", 101);
        addres1.setOfficeNumber("101");
        employeeDetails1.setAddress(addres1);
        employeeDetails1.setPosition("employee1");
        employeeDetails1.setPrivateNr("e1");
        employeeDetails1.setEmployee(employee1);
        employee1.setEmployeeDetails(employeeDetails1);

        EmployeeDetails employeeDetails2 = new EmployeeDetails();
        Address addres2 = new Address("Minsk", "Lenina", "2", 202);
        addres2.setOfficeNumber("202");
        employeeDetails2.setAddress(addres2);
        employeeDetails2.setPosition("employee2");
        employeeDetails2.setPrivateNr("e2");
        employeeDetails2.setEmployee(employee2);
        employee2.setEmployeeDetails(employeeDetails2);

        EmployeeDetails employeeDetails3 = new EmployeeDetails();
        Address addres3 = new Address("Minsk", "Lenina", "3", 303);
        addres3.setOfficeNumber("303");
        employeeDetails3.setAddress(addres3);
        employeeDetails3.setPosition("employee3");
        employeeDetails3.setPrivateNr("e3");
        employeeDetails3.setEmployee(employee3);
        employee3.setEmployeeDetails(employeeDetails3);

        //employee2.setDepartment(department1);
        //department1.setEmployees(Set.of(employee1, employee2));

        employeeDao.saveOrUpdate(employee1);

        employeeDao.saveOrUpdate(employee2);

        employeeDao.saveOrUpdate(employee3);

        assertTrue(employee1.getId() == 1);
        assertTrue(employee2.getId() == 2);
        assertTrue(employee3.getId() == 3);
    }

    @Test
    public void step2_updateEmployees() {
        assertTrue(true);
    }

    @Test
    public void step3_deleteEmployees() {
        Employee employee = employeeDao.load(1L);
        Employee employee2 = employeeDao.load(2L);
        employee.getDepartment().setEmployees(null);

        employeeDao.delete(1L);
        assertNull(employeeDao.find(1L));

        employeeDao.delete(2L);
        assertNull(employeeDao.find(2L));

        Employee employee3 = employeeDao.load(3L);
        employee3.getDepartment().setEmployees(null);
        employeeDao.delete(3L);
        assertNull(employeeDao.find(3L));
    }


    @After
    public void tearDown() {
        DaoImpl.isTestInstance = false;
        employeeDao = null;
    }

}
