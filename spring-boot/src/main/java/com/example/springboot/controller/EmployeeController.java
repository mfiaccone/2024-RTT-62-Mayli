package com.example.springboot.controller;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    @GetMapping("/employee")
    public ModelAndView employeeSearchByName(@RequestParam(required=false) String lastname) {

        ModelAndView response = new ModelAndView("employee");

        response.addObject("nameSearch", lastname);

        List<Employee> employees = employeeDao.findByLastName(lastname);
        response.addObject("employees", employees);

        return response;
    }

//    @GetMapping("/employee")
//    public ModelAndView employeeSearchByName(@RequestParam(required=false) String name) {
//
//        ModelAndView response = new ModelAndView("name");
//
////        List<Employee> employees = employeeDAO.findByLastName(name);
//
//        return response;
//    }
}
