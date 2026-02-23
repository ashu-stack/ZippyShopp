package com.ecom_project.shopify.controller;

import com.ecom_project.shopify.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
}
