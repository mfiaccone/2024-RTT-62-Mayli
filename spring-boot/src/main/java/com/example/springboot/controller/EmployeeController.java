package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.database.entity.Product;
import com.example.springboot.form.CreateEmployeeFormBean;
import com.example.springboot.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    // in phase 1 of component scan the constructor is called to create the new object
    // however the autowired fields are not set yet
    // in phase 2 the autowired fields are set
    // in phase 3 the @PostConstructor is called
    // constructors are no loner used very much in spring because of this

    @PostConstruct
    public void init() {
        // this is executed in phase 3 after all the autowired fields are set
        // this takes the place of a constructor for initialization code
    }

    @Autowired
    private EmployeeDAO employeeDao;

    @Autowired
    private CustomerDAO customerDao;

    @Autowired
    private OfficeDAO officeDao;

    @Autowired
    private EmployeeService employeeService;

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
        ModelAndView response = new ModelAndView("employee/detail");

        List<Customer> customers = customerDao.findBySalesRepEmployeeId(employeeId);
        response.addObject("customers", customers);

        Employee employee = employeeDao.findById(employeeId);
        response.addObject("employee", employee);

        loadDropdowns(response);

        return response;
    }

    private void loadDropdowns(ModelAndView response) {
        List<Employee> reportsToEmployees = employeeDao.findAll();
        response.addObject("reportsToEmployees", reportsToEmployees);

        // add your office query to get all of the offices and add it to the model
        List<Office> offices = officeDao.findAll();
        response.addObject("offices", offices);

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

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required=false) Integer employeeId) {
        //by setting required = false on the incoming parameter we allow null to enter the controller so that spring does not cause an error page
        // then we check if the input is null before trying to do our query

        // this view is the same for all the methods so far, even though it is named create.jsp and we are using it for edit
        ModelAndView response = new ModelAndView("/employee/create");

        // here again we have some duplicated code that could be refactored into a method
        // this list of employees is used in the Reports To drop down list
        List<Employee> reportsToEmployees = employeeDao.findAll();
        response.addObject("reportsToEmployees", reportsToEmployees);

        List<Office> offices = officeDao.findAll();
        response.addObject("offices", offices);

        // here i am checking the incoming employeeId to see if it is null or not (otherwise no reason to do below code)
        if (employeeId != null) {
            // load the employee from the database and set the form bean with all the employee values
            // this is because the form bean is on the JSP page, and we need to pre-populate the form with the employee data
            Employee employee = employeeDao.findById(employeeId);
            if (employee != null) {
                CreateEmployeeFormBean form = new CreateEmployeeFormBean();
                form.setEmployeeId(employee.getId());
                form.setEmail(employee.getEmail());
                form.setFirstName(employee.getFirstname());
                form.setLastName(employee.getLastname());
                form.setReportsTo(employee.getReportsTo());
                form.setOfficeId(employee.getOffice().getId());

                response.addObject("form", form);

            }
        }
        return response;
    }


    //you can use one or the other of the @PostMapping or @RequestMapping but not both
    @PostMapping("/createSubmit") //this is url not the file direction
    public ModelAndView createSubmit(@Valid CreateEmployeeFormBean form, BindingResult bindingResult) {
        //argument to the constructor here is the view now
        ModelAndView response = new ModelAndView();

        // we need to validate that the email does not exist in the database, however we only want to check if this is a create
        if (form.getEmployeeId() == null ) {
            Employee e = employeeDao.findByEmailIgnoreCase(form.getEmail());
            // if the e is not null then it was found in the database which means the email is already in use
            if ( e!= null ) {
                // this means the email already exists in the database
                bindingResult.rejectValue("email", "email", "This email is already in use. Manual Check");
            }
        }



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

            //call the employee service to create the employee
            Employee employee = employeeService.createEmployee(form);

            //redirecting to the employee detail.jsp page
            //however often times this would redirect to the edit page which we have not created yet
            // after the redirect is actually a URl and not a view name
            // in some ways this is overriding the behavior of the setViewName to use a URL rather than a JSP file location
            response.setViewName("redirect:/employee/detail?employeeId=" + employee.getId());




            return response;
        }

    }

}
