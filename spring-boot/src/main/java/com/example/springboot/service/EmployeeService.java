package com.example.springboot.service;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.form.CreateEmployeeFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDao;

    @Autowired
    private OfficeDAO officeDao;

    public Employee createEmployee(CreateEmployeeFormBean form) {

        // log out the incoming variables that are in the CreateEmployeeFormBean
        // variable name
        log.debug(form.toString());

        // first, I am going to take a shot at looking up the record in the database based on the incoming employeeId
        // this is from the hidden input field and is not something the user actually entered themselves
        //these lines of code are what make it either a create.jsp or an edit
        Employee employee = employeeDao.findById(form.getEmployeeId());
        if (employee == null) {
            // this means it was not found in the database so we are going to consider this a create.jsp
            employee = new Employee();
        }

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

        return employee;
    }

}
