package com.example.springboot.controller;

import com.example.springboot.database.entity.User;
import com.example.springboot.security.AuthenticatedUserUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        ModelAndView response = new ModelAndView("admin/dashboard");

        User user = authenticatedUserUtilities.getCurrentUser();
        log.debug(user.toString());

        return response;
    }

}

// when you want to add a product to a cart
// 1) Get the logged in user
// 2) Query from the order table where the user id is the logged in user and the status of the order = "CART"
// 3) If there is no cart, create a new order with the status of "CART" and set the logged in user on the order
// 4) Use the incoming product Id to query the product table and get the product entity
// 5) Create a new OrderDetails and set the product and the order and save

// when the user checks out
// 1) Get the logged in user
// 2) Query from the order table where the user id is the logged in user and the status of the order = "CART"
// 3) Change the status of the order to "CHECKOUT" save the order
