package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.database.entity.Product;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    @Autowired
    private CustomerDAO customerDao;

    @Autowired
    private OfficeDAO officeDao;

    @GetMapping
    public ModelAndView employeeSearchByName(@RequestParam(required = false) String lastname) {

        ModelAndView response = new ModelAndView("employee");

        response.addObject("nameSearch", lastname);

        List<Employee> employees = employeeDao.findByLastName(lastname);
        response.addObject("employees", employees);

        return response;

    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam Integer employeeId) {
        ModelAndView response = new ModelAndView("employee/detail.jsp");

        List<Customer> customers = customerDao.findBySalesRepEmployeeId(employeeId);
        response.addObject("customers", customers);

        Employee employee = employeeDao.findById(employeeId);
        response.addObject("employee", employee);

        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("/employee/create");

        // this list of employees is used in the Reports To dropdown to list all the employees
        List<Employee> reportsToEmployees = employeeDao.findAll();
        response.addObject("reportsToEmployees", reportsToEmployees);

        List<Office> officeList = officeDao.findAllOrderedByName(); // Fetch offices ordered by name
        response.addObject("offices", officeList);

        return response;


    }

    @GetMapping("/createSubmit") //this is url not the file direction
    public ModelAndView createSubmit(@Valid CreateEmployeeFormBean form, BindingResult bindingResult) {
        //argument to the constructor here is the view now
        ModelAndView response = new ModelAndView();

        // arguement to the constructor here is the view name - the view name can be a JSP location or a redirect URL
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            // we are in this part of the if statement so we know for sure that an error has occored
            // we are going to add the binding result to the model so we can use it on the JSP page to show the user the errors
            response.addObject("bindingResult", bindingResult);

            // because the page needs the list of employees for the drop down we need to add the list of employees to the model
            List<Employee> reportsToEmployees = employeeDao.findAll();
            response.addObject("reportsToEmployees", reportsToEmployees);

            // we need the list of offices
            List<Office> officeList = officeDao.findAllOrderedByName(); // Fetch offices ordered by name
            response.addObject("offices", officeList);

            //i'm going to set the view name to be
            response.setViewName("employee/create");

            // i'm going to add the form to the model so that we can display the user entered data in the form
            response.addObject("form", form);

            return response;

        } else {

            // log out the incoming variables that are in the CreateEmployeeFormBean
            // variable name
            log.debug(form.toString());

            Employee employee = new Employee();
            employee.setEmail(form.getEmail());
            employee.setFirstname(form.getFirstName());
            employee.setLastname(form.getLastName());
            employee.setReportsTo(form.getReportsTo());
            employee.setExtension(form.getExtension());
            employee.setJobTitle(form.getJobTitle());
//        employee.setOfficeId(form.getOfficeId());  this won't work bc it is set to insertable = false and updatable = false

            Office office = officeDao.findById(form.getOfficeId());
            employee.setOffice(office);

            //when we save to the database it will auto increment to give us a new id
            //the new ID is available in the return from the save method
            // basically returns the same object... after it's been inserted into the database
            employee = employeeDao.save(employee);

            //redirecting to the employee detail.jsp page
            //however often times this would redirect to the edit page which we have not created yet
            // after the redirect is actually a URl and not a view name
            // in some ways this is overriding the behavior of the setViewName to use a URL rather than a JSP file location
            response.setViewName("redirect:/employee/detail.jsp?employeeId=" + employee.getId());

            log.debug(form.toString());
            return response;
        }

    }

}
