package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderdetails")
public class OrderDetails {

    @Id // this is telling hibernate this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is telling hibernate that the PK is auto incremented
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "quantity_ordered")
    private Integer quantityOrdered;

    @Column(name = "price_each", columnDefinition = "DECIMAL")
    private Float priceEach;

    @Column(name = "order_line_number", columnDefinition = "SMALLINT")
    private Integer orderLineNumber;


}
