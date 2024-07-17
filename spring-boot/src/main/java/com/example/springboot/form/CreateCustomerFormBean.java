package com.example.springboot.form;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@ToString
public class CreateCustomerFormBean {

    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private Integer salesRepEmployeeId;



}
