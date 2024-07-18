package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Order;
import com.example.springboot.form.CreateCustomerFormBean;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private OfficeDAO officeDAO;

    @Autowired
    private OrderDAO orderDAO;

    @GetMapping
    public ModelAndView customer(@RequestParam(required = false) String name) {
        ModelAndView response = new ModelAndView("customer");
        List<Customer> customers = customerDAO.findCustomerByCustomerName(name);
        response.addObject("customers", customers);
        response.addObject("name", name);
        return response;
    }


    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam Integer customerId) {
        ModelAndView response = new ModelAndView("customer/detail");

        Customer customer = customerDAO.findCustomerById(customerId);
        response.addObject("customer", customer);

        List<Order> orders = orderDAO.findByCustomerId(customerId); // Assuming you have an OrderDAO
        response.addObject("orders", orders);

        Employee employee = employeeDAO.findById(customerId);
        response.addObject("employee", employee);

        return response;

    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("customer/create");

        // this list of employees is used in the Reports To dropdown to list all the employees
//        List<Customer> salesRepEmployee = customerDAO.findAll();
//        response.addObject("salesRepEmployee", salesRepEmployee);

//        List<Office> officeList = officeDao.findAllOrderedByName(); // Fetch offices ordered by name
//        response.addObject("offices", officeList);

        // Fetch and sort employees (sales reps) by ID
        List<Employee> salesRepEmployees = employeeDAO.findAll(); // Assuming employeeDAO is your DAO instance
        response.addObject("salesRepEmployees", salesRepEmployees);



        return response;


    }

    @GetMapping("/createSubmit") //this is url not the file direction
    public ModelAndView createSubmit(@Valid CreateCustomerFormBean form, BindingResult bindingResult) {
        //argument to the constructor here is the view now
        ModelAndView response = new ModelAndView();

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);

            List<Employee> salesRepEmployees = employeeDAO.findAll();
            response.addObject("salesRepEmployees", salesRepEmployees);

            response.setViewName("customer/create");

            response.addObject("form", form);


            return response;
        } else {
            Customer customer = new Customer();
            customer.setCustomerName(form.getCustomerName());
            customer.setContactLastName(form.getContactLastName());
            customer.setContactFirstName(form.getContactFirstName());
            customer.setPhone(form.getPhone());
            customer.setAddressLineOne(form.getAddressLineOne());
            customer.setAddressLineTwo(form.getAddressLineTwo());
            customer.setCity(form.getCity());
            customer.setState(form.getState());
            customer.setPostalCode(form.getPostalCode());
            customer.setCountry(form.getCountry());
            customer.setSalesRepEmployeeId(form.getSalesRepEmployeeId());


//         Office office = officeDAO.findById(form.findById());
            // customer.setOffice(office); // Assuming Customer entity has a setOffice method

            // Save the customer to the database
            customer = customerDAO.save(customer);

            // Redirect to customer detail.jsp page or any other appropriate page
            response.setViewName("redirect:/customer/detail?customerId=" + customer.getId());


            return response;
        }
    }
}