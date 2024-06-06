package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id // this is telling hibernate this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is telling hibernate that the PK is auto incremented
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "productline_id")
    private Integer productLineId;

    @Column(name = "product_scale")
    private String productScale;

    @Column(name = "product_vendor")
    private String productVendor;

    @Column(name = "product_description", length = 65535, columnDefinition="Text")
    private String productDescription;

    @Column(name = "quantity_in_stock", columnDefinition="smallint")
    private Integer quantityInStock;

    @Column(name = "buy_price", columnDefinition="Decimal")
    private Double buyPrice;

    @Column(name = "msrp", columnDefinition="Decimal")
    private Double msrp;

}
