package com.example.springboot.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {

    //ordering in this file does not matter

    @Id // this is telling hibernate this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is telling hibernate that the PK is auto incremented
    @Column(name = "id", insertable=false, updatable=false)
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

    // this is allowing hibernate to make this query
    // select e.* from customers c, employee e where c.sales_rep_employee_id = e.id and c.id = ###;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "sales_rep_employee_id", nullable = true)
    private Employee employee;

    //because we added the @ManyToOne annotation (just above) this column is now considered a duplicate in hibernate
    //by adding the insertable = false and the updatable = false we are essentially turning this into a read only variable!!!!
    //this will happen for an FK that we use with a @ManyToOne annotation
    @Column(name = "sales_rep_employee_id", insertable = false, updatable = false)
    private Integer salesRepEmployeeId;

    @Column(name = "credit_limit", columnDefinition = "DECIMAL")
    private Float creditLimit;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Order> orders;

}