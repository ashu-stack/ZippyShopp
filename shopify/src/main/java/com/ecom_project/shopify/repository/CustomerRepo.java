package com.ecom_project.shopify.repository;

import com.ecom_project.shopify.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepo extends JpaRepository<Customer, UUID> {

}
