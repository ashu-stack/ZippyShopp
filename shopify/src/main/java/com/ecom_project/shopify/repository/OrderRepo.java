package com.ecom_project.shopify.repository;

import com.ecom_project.shopify.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepo extends JpaRepository<Orders,Integer> {
    List<Orders> findOrdersByCustomerId(Integer cId);

    List<Orders> findOrdersBeforeDate(Date date);


}
