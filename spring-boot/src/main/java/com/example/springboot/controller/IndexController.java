package com.example.springboot.controller;

import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class IndexController {


    @Autowired
    private ProductDAO productDao;

    @GetMapping("/")
    public ModelAndView index(@RequestParam(required=false) Integer id) {
        // by default, the @RequestParam is required, meaning if it is missing in the URL spring will send you to the error page
        // if the id parameter is not present ont he URL, then the incoming id will be null
        // this function is for the home page of the website which is expressed as just a plain slash "/"
        ModelAndView response = new ModelAndView("index");

        Product product = productDao.findById(id);
        response.addObject("productKey", product);

        // by default the logging level is set to info so the debug message will not be printed in the terminal
        log.debug("Debug level");
        log.info("Info level");
        log.warn("Warn level");
        log.error("Error level");

        //now that we have logging, NEVER use System.out.println in a spring application on the job
        System.out.println("This is forbidden at all times.");


        response.addObject("'message", "Hello World!");

        return response;
    }

    @GetMapping("/index/{id}")
    public ModelAndView indexPathVar(@PathVariable Integer id) {
        // by default, the @PathVariable is required, meaning if it is missing in the URL spring will send you to the error page
        // this is the same as the above, but this is getting more common because it uses the slug (better for google searches)
        // by using the name attribute in the @PathVariable annotation, you can change the name of the variable
        // so in this case it is mapping the id in the URL to the productID variable
        ModelAndView response = new ModelAndView("index");

        Product product = productDao.findById(id);
        response.addObject("productKey", product);

        response.addObject("'message", "Hello World!");


        return response;
    }

    @GetMapping("/page-url")
    public ModelAndView canBeAnyFunctionNameYouWant() {
        // this page is for another page of the website which is expressed as "/page-url"
        ModelAndView response = new ModelAndView("another-page");

        return response;
    }

    @GetMapping("/search")
    public ModelAndView search() {
        // this page is for another page of the website which is expressed as "/search"
        ModelAndView response = new ModelAndView("search");

        List<Product> products = productDao.findAll();
        response.addObject("products", products);

        return response;
    }
}
