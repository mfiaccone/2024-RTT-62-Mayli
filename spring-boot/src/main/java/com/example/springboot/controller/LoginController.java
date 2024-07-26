package com.example.springboot.controller;

import com.example.springboot.database.dao.UserDAO;
import com.example.springboot.database.dao.UserRoleDAO;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.User;
import com.example.springboot.form.CreateAccountFormBean;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller("auth")
public class LoginController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @GetMapping("/create-account")
    public ModelAndView createAccount() {

        ModelAndView response = new ModelAndView("auth/create-account");



        return response;
    }

    @PostMapping
    public ModelAndView createAccountSubmit(@Valid CreateAccountFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView("auth/create-account");

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);

        } else {

            User user = new User();

            user.setEmail(form.getEmail());
            user.setPassword(form.getPassword());

            userDao.save(user);
            
        }

        return response;
    }

}
