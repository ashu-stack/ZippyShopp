package com.ecom_project.shopify.controller;

import com.ecom_project.shopify.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
}
