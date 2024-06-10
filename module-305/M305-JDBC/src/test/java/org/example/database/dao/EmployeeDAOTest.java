package org.example.database.dao;

import org.example.database.entity.Employee;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeeDAOTest {

    private static EmployeeDAO employeeDao = new EmployeeDAO();

    @Test
    public void findByIdTest() {
        //given
        Integer userId = 1002;

        //when
        Employee employee = employeeDao.findById(userId);

        //then
        Assertions.assertNotNull(userId);
        Assertions.assertEquals(userId, employee.getId());

    }

    @Test
    public void findByIdInvalidTest() {
        //given
        Integer userId = 1029384;

        //when
        Employee employee = employeeDao.findById(userId);

        //then
        Assertions.assertNull(employee);
    }

    @Test
    public void findByFirstNameTest() {
        //given
        String firstName = "Steve";

        //when
        List<Employee> employee = employeeDao.findByFirstName(firstName);
        Employee thisEmployee = employee.get(0);

        //then
        Assertions.assertNotNull(employee);
        Assertions.assertEquals(firstName, thisEmployee.getFirstname());
    }

    @Test
    public void findByInvalidFirstNameTest() {
        //given
        String firstName = "Mayli";

        //when
        List<Employee> employee = employeeDao.findByFirstName(firstName);

        //then
        Assertions.assertNotNull(employee); // list is not null
        Assertions.assertTrue(employee.isEmpty()); //returned list is empty because there is no mayli
    }


    @Test
    public void insertAndDeleteTest() {

//        ---------- insert -----------
        //given
        Employee given = new Employee();

        given.setFirstname("Test");
        given.setLastname("Name");
        given.setId(789);
        given.setOfficeId(2);
        given.setExtension("x1234");
        given.setEmail("none2@noemail.com");
        given.setJobTitle("Student");

        //when
        employeeDao.insert(given);

        //then
        Employee actual = employeeDao.findById(given.getId());

        Assertions.assertEquals(given.getFirstname(), actual.getFirstname());
        Assertions.assertEquals(given.getLastname(), actual.getLastname());

        // delete
        employeeDao.delete(given);

    }

    @AfterAll
    @BeforeAll
    public static void cleanup() {

       List<Employee> testEmployee = employeeDao.findByFirstName("Test");

       for (Employee employee : testEmployee) {
           employeeDao.delete(employee);
       }

    }

}
