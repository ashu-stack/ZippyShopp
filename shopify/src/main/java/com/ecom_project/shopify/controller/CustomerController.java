package com.ecom_project.shopify.controller;

import com.ecom_project.shopify.model.Customer;
import com.ecom_project.shopify.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    //getAll
    @GetMapping("/customer/getAll")
    public List<Customer> getCustomers(){
       return customerService.getAllCustomers();
    }

    //get by id
    @GetMapping("/customer/getById/{id}")
    public Customer getCustomerById(@PathVariable UUID id){
        return customerService.getCustomerById(id);
    }

    // put
    @PostMapping("/customer/addCustomer")
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    // delete
    @DeleteMapping("/customer/deleteById/{id}")
    public void deleteCustomer(@PathVariable UUID id){
        customerService.deleteCustomer(id);
    }

}
