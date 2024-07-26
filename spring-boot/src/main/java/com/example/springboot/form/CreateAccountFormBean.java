package com.example.springboot.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

@Getter
@Setter
public class CreateAccountFormBean {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

}
