package org.example.database.dao;


import org.example.database.entity.Customer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CustomerDAOTest {

    private static CustomerDAO customerDao = new CustomerDAO(); // needs to be static if you are going to use a before all

    @BeforeAll
    public static void beforeAll() {
        //one use is to prepare or to cleanup data in the database either before or after all your test cases run
        //we could write some code to delete any customer from the database that has the "Test Customer" as the name

        //another example of something we could here in the before All
        // if we were doing an old school JDBC connection we could create the actual database connection here
        // so that all the methods in this test case already have a database connection they could use
        //then in an @AfterAll you can close the database connection and release the resources
    }


    @Test
    public void findByIdTest() {
        // given
        Integer userid = 103;

        //when
        Customer customer = customerDao.findById(userid);

        //then
        //the expected value, meaning the value you are expecting it to be is the first arguement
        //the actual value, meaning the value returned or modified by the test function is the 2nd arguement
        Assertions.assertNotNull(customer);
        Assertions.assertEquals(userid, customer.getId());
        Assertions.assertEquals("Atelier graphique", customer.getCustomerName());
        Assertions.assertEquals("asdf", customer.getContactLastName());

    }

    @Test
    public void findByInvalidTest() {
        //given
        Integer userid = 103033;

        //when
        Customer customer = customerDao.findById(userid);

        //then
        Assertions.assertNull(customer);
    }

    @Test
    public void createNewCustomer() {
        //given
        Customer given = new Customer();

        given.setCustomerName("Test Customer");
        given.setContactFirstName("Firstname");
        given.setContactLastName("Lastname");
        given.setAddressLineOne("address1");
        given.setCity("somewehre");
        given.setCountry("USA");
        given.setPhone("1232343423");


        //when
        customerDao.insert(given);

        //then
        Customer actual = customerDao.findById(given.getId());

        Assertions.assertEquals(given.getCustomerName(), actual.getCustomerName());
        Assertions.assertEquals(given.getContactFirstName(), actual.getContactFirstName());
    }



}
