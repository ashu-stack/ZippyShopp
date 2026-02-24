package com.ecom_project.shopify.service;

import com.ecom_project.shopify.model.Customer;
import com.ecom_project.shopify.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> getAllCustomers() {
       return customerRepo.findAll();
    }

    public Customer getCustomerById(UUID id) {
        return (Customer) customerRepo.findById(id).orElse(null);
    }

    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
    }


    public void deleteCustomer(UUID id) {
        customerRepo.deleteById(id);
    }
}
