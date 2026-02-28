package com.ecom_project.shopify.controller;

import com.ecom_project.shopify.model.Customer;
import com.ecom_project.shopify.repository.CustomerRepo;
import com.ecom_project.shopify.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepo customerRepo;



    //getAll
    @GetMapping("/customer/getAll")
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> list = customerService.getAllCustomers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //get by id
    @GetMapping("/customer/getById/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable UUID id){
        Customer customer = customerService.getCustomerById(id);
        if(customer != null){
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // put
    @PostMapping("/customer/addCustomer")
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    // delete
    @DeleteMapping("/customer/deleteById/{id}")
    public ResponseEntity deleteCustomer(@PathVariable UUID id){
        customerService.deleteCustomer(id);
        return new ResponseEntity(HttpStatus.GONE);
    }

}
