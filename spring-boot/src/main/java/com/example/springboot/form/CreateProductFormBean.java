package com.example.springboot.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductFormBean {

    private String productCode;
    private String productName;
    private Integer productLineId;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private Integer quantityInStock;
    private Double buyPrice;
    private Double msrp;


}
