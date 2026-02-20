package com.ecom_project.shopify.repository;

import com.ecom_project.shopify.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders,Integer> {

}
