package com.ecom_project.shopify.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Customer implements UserDetails {

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

    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    private List<Orders> ordersList;


    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    private List<Payment> payments;

    @OneToOne
    private Cart cart;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return "";
    }
}
