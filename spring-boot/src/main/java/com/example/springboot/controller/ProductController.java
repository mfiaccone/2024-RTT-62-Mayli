package com.example.springboot.controller;

import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Office;
import com.example.springboot.database.entity.Product;
import com.example.springboot.form.CreateProductFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/detail")
    public ModelAndView productDetail(@RequestParam Integer productId) {
        ModelAndView modelAndView = new ModelAndView("/product/detail");

        Product product = productDAO.findById(productId);
        modelAndView.addObject("product", product);

        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("/product/create");

        List<Product> productVendorList = productDAO.findAll();
        response.addObject("productVendorList", productVendorList);

        return response;
    }

    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(CreateProductFormBean form) {

        ModelAndView response = new ModelAndView("/product/createSubmit");

        Product product = new Product();
        product.setProductName(form.getProductName());
        product.setProductCode(form.getProductCode());
        product.setProductLineId(form.getProductLineId());
        product.setProductScale(form.getProductScale());
        product.setProductVendor(form.getProductVendor());
        product.setProductDescription(form.getProductDescription());
        product.setQuantityInStock(form.getQuantityInStock());
        product.setBuyPrice(form.getBuyPrice());
        product.setMsrp(form.getMsrp());





        product = productDAO.save(product);

         return response;
    }
}