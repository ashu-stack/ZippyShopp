package com.ecom_project.shopify.service;

import com.ecom_project.shopify.model.Orders;
import com.ecom_project.shopify.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    public List<Orders> getAllOrders() {
        return orderRepo.findAll();
    }

    public Orders getOrdersById(Integer id) {
        return (Orders) orderRepo.findById(id).orElse(null);
    }

    public void addOrder(Orders orders) {
        orderRepo.save(orders);
    }

    public void deleteOrder(Integer id) {
        orderRepo.deleteById(id);
    }
}
