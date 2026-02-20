package com.ecom_project.shopify.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private Integer custId;
    @Column(nullable = false)
    private Date orderDate;

    @Column(nullable = false)
    private Float amount;

    @OneToMany(mappedBy = "orders")
    private List<Product> productList;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
