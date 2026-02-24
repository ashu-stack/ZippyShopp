package com.ecom_project.shopify.repository;

import com.ecom_project.shopify.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer> {


}
