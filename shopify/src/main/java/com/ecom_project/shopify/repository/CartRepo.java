package com.ecom_project.shopify.repository;

import com.ecom_project.shopify.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {
     Cart findByCustomerId( UUID customerId);
}
