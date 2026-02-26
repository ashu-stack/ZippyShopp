package com.ecom_project.shopify.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private UUID custId;
    @Column(nullable = false)
    private LocalDate orderDate;

    @Column(nullable = false)
    private Integer amount;

    @OneToMany(mappedBy = "orders")
    private List<Product> productList;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
