package com.example.springboot.controller;


import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.database.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @GetMapping("/detail")
    public ModelAndView orderDetail(@RequestParam Integer orderId) {
        ModelAndView response = new ModelAndView("order/detail");

        Order order = orderDAO.findById(orderId).orElse(null);
        response.addObject("order", order);

        List<Map<String,Object>> orderDetails = orderDAO.getOrderDetails(orderId);
        response.addObject("orderDetails", orderDetails);


        return response;
    }


}