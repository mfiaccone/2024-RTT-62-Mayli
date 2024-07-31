package com.example.springboot.service;

import com.example.springboot.database.dao.UserDAO;
import com.example.springboot.database.dao.UserRoleDAO;
import com.example.springboot.database.entity.User;
import com.example.springboot.database.entity.UserRole;
import com.example.springboot.form.CreateAccountFormBean;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class UserService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleDAO userRoleDao;

    public User createUser(CreateAccountFormBean form) {
        User user = new User();

        user.setEmail(form.getEmail());
        //encrypt the password before saving it to the database
        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);


        user.setCreateDate(new Date());

        // save the user to the database
        userDao.save(user);

        // create a user role for the user
        UserRole userRole = new UserRole();
        userRole.setRoleName("USER");
        userRole.setUserId(user.getId());

        userRoleDao.save(userRole);

        return user;
    }
}
