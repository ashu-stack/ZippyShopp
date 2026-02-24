package com.ecom_project.shopify.controller;

import com.ecom_project.shopify.model.Orders;
import com.ecom_project.shopify.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class OrderController {
    @Autowired
    OrderService orderService;

    //getAll
    @GetMapping("/orders/getAll")
    public ResponseEntity<List<Orders>> getOrders(){
        List<Orders> list = orderService.getAllOrders();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //get by id
    @GetMapping("/orders/getById/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Integer id){
        Orders orders =  orderService.getOrdersById(id);
        if(orders != null){
            return new ResponseEntity<>(orders,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // put
    @PostMapping("/orders/addOrder")
    public ResponseEntity addOrder(@RequestBody Orders orders){
        orderService.addOrder(orders);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // delete

    @DeleteMapping("/orders/deleteOrder/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
