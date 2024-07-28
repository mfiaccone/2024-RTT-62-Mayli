package com.example.springboot.controller;

import com.example.springboot.database.dao.*;
import com.example.springboot.database.entity.*;
import com.example.springboot.form.*;
import com.example.springboot.service.UserService;
import jakarta.validation.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("/account")
public class LoginController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserService userService;


    @GetMapping("/create-account")
    public ModelAndView createAccount() {
        ModelAndView response = new ModelAndView("auth/create-account");

        return response;
    }

    @PostMapping("/create-account")
    public ModelAndView createAccountSubmit(@Valid CreateAccountFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView("auth/create-account");

        if (form.getId() == null ) {
            User u = userDao.findByEmailIgnoreCase(form.getEmail());
            // if the e is not null then it was found in the database which means the email is already in use
            if ( u!= null ) {
                // this means the email already exists in the database
                bindingResult.rejectValue("email", "email", "This email is already in use. Manual Check");
            }
        }

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
        } else {
            // there were no errors so we can create the new user in the database
            userService.createUser(form);

        }

        return response;
    }


}
