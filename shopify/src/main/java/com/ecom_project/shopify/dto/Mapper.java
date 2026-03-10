package com.ecom_project.shopify.dto;

import com.ecom_project.shopify.model.Customer;
import com.ecom_project.shopify.model.Product;

public class Mapper {

    public CustomerDTO customerDTO(Customer customer){
        String name = customer.getName();
        String lastName = customer.getLastName();
        String email = customer.getEmail();

        return new CustomerDTO(name, lastName,email);
    }

    public ProductDTO productDTO(Product product){
        String name = product.getName();
        Integer price = product.getPrice();
        boolean available = product.isAvailable();
        String description = product.getDescription();

        return new ProductDTO(name,price,available,description);

    }


}
