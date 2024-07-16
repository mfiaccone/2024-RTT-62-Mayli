package com.example.springboot.form;

import lombok.*;

@Getter
@Setter
@ToString
public class CreateEmployeeFormBean {

    private String email;
    private String firstName;
    private String lastName;

    //we are going to make this data type an integer because we know that we want to add it to the database as an integer
    private Integer reportsTo;

    private String extension;
    private String jobTitle;
    private Integer officeId;

}
