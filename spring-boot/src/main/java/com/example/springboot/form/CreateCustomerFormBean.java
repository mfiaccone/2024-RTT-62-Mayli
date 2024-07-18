package com.example.springboot.form;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@ToString
public class CreateCustomerFormBean {

    @NotEmpty(message="Customer Name is required.")
    private String customerName;

    @NotEmpty(message="Last Name is required.")
    private String contactLastName;

    @NotEmpty(message="First Name is required.")
    private String contactFirstName;

    @NotEmpty(message="Phone number is required.")
    private String phone;

    @NotEmpty(message="Address Line One is required.")
    private String addressLineOne;

    @NotEmpty(message="Address Line Two is required.")
    private String addressLineTwo;

    @NotEmpty(message="City is required.")
    private String city;

    @NotEmpty(message="State is required.")
    private String state;

    @NotEmpty(message="Postal Code is required.")
    private String postalCode;

    @NotEmpty(message="Country is required.")
    private String country;

    private Integer salesRepEmployeeId;





}
