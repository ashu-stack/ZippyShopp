package com.ecom_project.shopify.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false,
    length = 50)
    private String name;

    @Column(length = 50)
    private String lastName;

    @Column(nullable = false,
    unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "customer")
    private List<Orders> ordersList;
}
