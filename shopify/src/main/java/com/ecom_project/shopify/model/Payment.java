package com.ecom_project.shopify.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(name = "pay_seq",
    allocationSize = 2)
    private Integer id;
    @Column(nullable = false,
    length = 15)
    private String type;

    @Column(nullable = false)
    private Integer amount;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id") //Owner of Payment-Customer rel => has a FK => no sense w/o customer
    private Customer customer;
}
