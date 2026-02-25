package com.ecom_project.shopify.repository;

import com.ecom_project.shopify.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, UUID> {
        Customer findByNameAndLastName(String name, String lastName);
}
