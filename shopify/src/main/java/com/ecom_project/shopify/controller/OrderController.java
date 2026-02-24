package com.ecom_project.shopify.controller;

import com.ecom_project.shopify.model.Orders;
import com.ecom_project.shopify.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class OrderController {
    @Autowired
    OrderService orderService;

    //getAll
    @GetMapping("/orders/getAll")
    public List<Orders> getOrders(){
        return orderService.getAllOrders();
    }

    //get by id
    @GetMapping("/orders/getById/{id}")
    public Orders getOrderById(@PathVariable Integer id){
        return orderService.getOrdersById(id);
    }

    // put
    @PostMapping("/orders/addOrder")
    public void addOrder(@RequestBody Orders orders){
        orderService.addOrder(orders);
    }

    // delete

    @DeleteMapping("/orders/deleteOrder/{id}")
    public void delete(@PathVariable Integer id){
        orderService.deleteOrder(id);
    }
}
