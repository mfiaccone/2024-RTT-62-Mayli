package org.example;

import org.example.database.dao.EmployeeDAO;
import org.example.database.entity.Customer;
import org.example.database.dao.CustomerDAO;
import org.example.database.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class FirstHibernateDemo {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();

//        //lets create a new employee in the database
//        Employee newEmployee = new Employee();
//
//        newEmployee.setFirstname("First NAME! ! !");
//        newEmployee.setLastname("lastname");
//        newEmployee.setEmail("rtt6211@perschols.org");
//        newEmployee.setOfficeId(3);
//        newEmployee.setExtension("X12345");
//        newEmployee.setJobTitle("Newbie");
//        newEmployee.setVacationHours(0);
//
//        employeeDAO.insert(newEmployee);

//        List<Employee> employees = employeeDAO.findByFirstName("Leslie");
//
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }

        // this employee id exists in the database and will return a record
        Employee employee = employeeDAO.findById(1056);
        System.out.println(employee);

        //this employee id does not exist in the database and will return null
        employee = employeeDAO.findById(1);
        System.out.println(employee);

        //----- HW Questions ------

        //testing findByCustomerName
        CustomerDAO customerDAO = new CustomerDAO();

        List<Customer> customerName = customerDAO.findByCustomerName("Mini Classics");
        System.out.println(customerName);

        //testing findByContactFirstName
        List<Customer> contactFirstName = customerDAO.findByContactFirstName("Peter");
        System.out.println(contactFirstName);


        // testing find by id
        Customer customer = customerDAO.findById(114);
        System.out.println(customer);

        //use scanner to prompt first/last name

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a first name:");
        scanner.nextLine();
        System.out.println("Please enter a last name:");
        scanner.nextLine();

    }


}