package com.example.springboot.service;

import com.example.springboot.database.dao.UserDAO;
import com.example.springboot.database.entity.User;
import com.example.springboot.form.CreateAccountFormBean;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class UserService {

    @Autowired
    private UserDAO userDao;

    public User createUser(CreateAccountFormBean form) {
        User user = new User();

        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setCreateDate(new Date());

        // save the user to the database
        userDao.save(user);

        return user;
    }
}
