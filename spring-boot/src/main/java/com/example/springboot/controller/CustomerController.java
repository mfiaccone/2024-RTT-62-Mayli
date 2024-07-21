package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.database.entity.Order;
import com.example.springboot.form.CreateCustomerFormBean;
import com.example.springboot.form.CreateEmployeeFormBean;
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
        ModelAndView response = new ModelAndView("customer/create.jsp");

        // Fetch and sort employees (sales reps) by ID
        List<Employee> salesRepEmployees = employeeDAO.findAll(); // Assuming employeeDAO is your DAO instance
        response.addObject("salesRepEmployees", salesRepEmployees);

        return response;

    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required=false) Integer customerId) {
        //by setting required = false on the incoming parameter we allow null to enter the controller so that spring does not cause an error page
        // then we check if the input is null before trying to do our query

        // this view is the same for all the methods so far, even though it is named create.jsp and we are using it for edit
        ModelAndView response = new ModelAndView("/customer/create.jsp");

        // here again we have some duplicated code that could be refactored into a method
        // this list of employees is used in the Reports To drop down list
        List<Employee> reportsToEmployees = employeeDAO.findAll();
        response.addObject("reportsToEmployees", reportsToEmployees);


        // here i am checking the incoming employeeId to see if it is null or not (otherwise no reason to do below code)
        if (customerId != null) {
            // load the employee from the database and set the form bean with all the employee values
            // this is because the form bean is on the JSP page, and we need to pre-populate the form with the employee data
            Customer customer = customerDAO.findCustomerById(customerId);
            if (customer != null) {
                CreateCustomerFormBean form = new CreateCustomerFormBean();

                form.setCustomerId(customer.getId());
                form.setCustomerName(customer.getCustomerName());
                form.setContactLastName(customer.getContactLastName());
                form.setContactFirstName(customer.getContactFirstName());
                form.setPhone(customer.getPhone());
                form.setAddressLineOne(customer.getAddressLineOne());
                form.setAddressLineTwo(customer.getAddressLineTwo());
                form.setCity(customer.getCity());
                form.setState(customer.getState());
                form.setPostalCode(customer.getPostalCode());
                form.setCountry(customer.getCountry());

                response.addObject("form", form);

            }
        }
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

            response.setViewName("customer/create.jsp");

            response.addObject("form", form);


            return response;
        } else {

            // first, I am going to take a shot at looking up the record in the database based on the incoming employeeId
            // this is from the hidden input field and is not something the user actually entered themselves
            Customer customer = customerDAO.findCustomerById(form.getCustomerId());
            if ( customer == null) {
                // this means it was not found in the database so we are going to consider this a create.jsp
                customer = new Customer();
            }

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


            // Save the customer to the database
            customer = customerDAO.save(customer);

            // Redirect to customer detail.jsp page or any other appropriate page
            response.setViewName("redirect:/customer/detail?customerId=" + customer.getId());


            return response;
        }
    }
}