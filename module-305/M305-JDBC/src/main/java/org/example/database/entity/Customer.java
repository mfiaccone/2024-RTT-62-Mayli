package org.example.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


    @Setter
    @Getter
    @Entity
    @Table(name = "customers")
    public class Customer {

        @Id // this is telling hibernate this column is the PK
        @GeneratedValue(strategy = GenerationType.IDENTITY) // this is telling hibernate that the PK is auto incremented
        @Column(name = "id")
        private Integer id;

        @Column(name = "customer_name")
        private String customerName;

        @Column(name = "contact_lastname")
        private String contactLastName;

        @Column(name = "contact_firstname")
        private String contactFirstName;

        @Column(name = "phone")
        private String phone;

        @Column(name = "address_line1")
        private String addressLineOne;

        @Column(name = "address_line2")
        private String addressLineTwo;

        @Column(name = "city")
        private String city;

        @Column(name = "state")
        private String state;

        @Column(name = "postal_code")
        private String postalCode;

        @Column(name = "country")
        private String country;

        @Column(name = "sales_rep_employee_id")
        private Integer salesRepEmployeeId;

        @Column(name = "credit_limit")
        private Double creditLimit;

    }
