package com.ecom_project.shopify.model;

import com.ecom_project.shopify.util.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users")
@Builder
public class Users implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.stream().map(roles ->
                new SimpleGrantedAuthority("ROLE_" + roles.name())).collect(Collectors.toSet());
    }

    @Override
    public String getUsername() {
        return this.userName;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String userName;

    String password;
    String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    Set<Role> role;


}
