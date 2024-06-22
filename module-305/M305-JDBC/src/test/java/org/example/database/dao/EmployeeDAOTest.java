package org.example.database.dao;

import org.example.database.entity.Employee;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    // another way to do the above test below

    @Test
    public void FindByFirstNameSecondTest() {
        String firstName = "Leslie";

        //when
        List<Employee> employees = employeeDao.findByFirstName(firstName);

        //then
        Assertions.assertTrue(employees.size() > 0);
        for ( Employee e : employees ) {
            Assertions.assertEquals(firstName, e.getFirstname());
        }
    }

    //a third way to do the above test using a parameterized test

    @ParameterizedTest
    @CsvSource ( { "Leslie", "Tom" } )
    public void findByFirstNameThirdTest (String firstName) {
            //given (in the csv source now)

        //when
        List<Employee> employees = employeeDao.findByFirstName(firstName);

        //then
        Assertions.assertTrue(employees.size() > 0);
        for ( Employee e : employees ) {
            Assertions.assertEquals(firstName, e.getFirstname());

    }
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

    // eric's example
    @Test
    public void createEmployeeTest() {

        Employee given = new Employee();

        given.setFirstname("Test Employee");
        given.setLastname("Lastname");
        given.setJobTitle("Job Title");
        given.setEmail("employee@employee.com");
        given.setOfficeId(1);
        given.setExtension("24");
        given.setReportsTo(1088);
        given.setVacationHours(10);
        given.setProfileImageUrl("http://example.com/profile/testemployee");

        employeeDao.insert(given);
        //right here.. given is going to have an id
        //hibernate will create the new PK id value and set it on the given object as part of the save

        Employee actual = employeeDao.findById(given.getId());

        Assertions.assertEquals(given.getFirstname(), actual.getFirstname());
        Assertions.assertEquals(given.getLastname(), actual.getLastname());
        // ... add all the rest of the assertions here to validate the object is the same

        //now lets delete the record from the database
        employeeDao.delete(given);

        //we could do even one more after this to verify that it is indeed gone
        Employee delete = employeeDao.findById(given.getId());
        Assertions.assertNull(delete);

    }
}
