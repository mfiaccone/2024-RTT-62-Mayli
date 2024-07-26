package com.example.springboot.controller;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Slf4j
@Controller
public class IndexController {


    @Autowired
    private ProductDAO productDao;

    @Autowired
    private EmployeeDAO employeeDAO;

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
    public ModelAndView search(@RequestParam(required=false) String search) {
        // this page is for another page of the website which is expressed as "/search"
        ModelAndView response = new ModelAndView("search");

        log.debug("The user searched for the terms: " + search);

        // I am going to add the user input back to the model so that we can display the search in the form
        // (so user can see what they searched for) put this in the jsp input line:  value="${search}"
        response.addObject("search", search);

        List<Product> products = productDao.findByNameorCode(search);
        response.addObject("products", products);

        return response;
    }

    @GetMapping("/homework")
    public ModelAndView homework(@RequestParam(required=false) String homework) {

        ModelAndView response = new ModelAndView("homework");

        return response;
    }

    @GetMapping("/file-upload")
    public ModelAndView fileUpload(@RequestParam Integer employeeId) {
        ModelAndView response = new ModelAndView("file-upload");
        response.addObject("employeeId", employeeId);
        return response;
    }

    @PostMapping("/file-upload")
    public ModelAndView fileUploadSubmit(@RequestParam MultipartFile file, @RequestParam Integer employeeId) {

        ModelAndView modelAndView = new ModelAndView("redirect:/employee/detail?employeeId=" + employeeId);

        log.debug("The file name is: " + file.getOriginalFilename());
        log.debug("The file size is: " + file.getSize());
        log.debug("The file content type is: " + file.getContentType());

        // save the file to the server
        // homework: use the original file name and get a substring of the last index of . to the end of the string then restrict based on jpg or png
        // use the model to put an error message on the page
        // you can use the binding result in the form bean to restrict it

        // this is the location to save to the hard drive
        String saveFilename = "./src/main/webapp/pub/images/" + file.getOriginalFilename();

        // this Files.copy is a utility that will read the stream one chunk at a time and write it to a file.
        // first arg is the input stream to read from the uploaded file
        // 2nd is the filename where we want to write the file
        // 3rd says to overwrite if existing.
        try {
            Files.copy(file.getInputStream(), Paths.get(saveFilename), StandardCopyOption.REPLACE_EXISTING);
        } catch ( Exception e ) {
            log.error("Unable to finish reading file", e);
        }

        // we can load the record from the database based on the incoming employeeId
        Employee employee = employeeDAO.findById(employeeId);

        // this is the URL to get the image
        String url = "/pub/images/" + file.getOriginalFilename();
        employee.setProfileImageUrl(url);

        employeeDAO.save(employee);

        return modelAndView;
    }
}
