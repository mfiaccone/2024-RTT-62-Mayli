package com.example.springboot.validation;

import jakarta.validation.*;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomerEmailUniqueImpl.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomerEmailUnique {

    String message() default "{CustomerEmailUnique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}