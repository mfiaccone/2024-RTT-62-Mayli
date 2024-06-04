package org.example.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order {

    @Id // this is telling hibernate this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is telling hibernate that the PK is auto incremented
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Column(name = "required_date")
    @Temporal(TemporalType.DATE)
    private Date requiredDate;

    @Column(name = "shipped_date")
    @Temporal(TemporalType.DATE)
    private Date shippedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "comments")
    private String comments;


}
