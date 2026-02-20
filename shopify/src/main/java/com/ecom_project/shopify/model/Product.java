package com.ecom_project.shopify.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "prod_seq"
    )
    @SequenceGenerator(name = "prod_seq",
    allocationSize = 2)
    private Integer id;
    @Column(
            name = "product_name",
            unique = true,
            nullable = false
    )
    private String name;
    @Column(
            nullable = false
    )
    private BigDecimal price;
    @Column(
            nullable = false
    )
    private boolean available;

    @Column(
            length = 100
    )
    private String description;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

}
