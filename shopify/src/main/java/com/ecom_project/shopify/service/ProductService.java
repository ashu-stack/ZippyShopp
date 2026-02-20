package com.ecom_project.shopify.service;

import com.ecom_project.shopify.model.Product;
import com.ecom_project.shopify.repository.ProductRepo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;


    public List<Product> getAllProd() {
        return productRepo.findAll();
    }

    public void addNewProd(Product product) {
        productRepo.save(product);
    }

    public Product getProdById(int id) {
       return productRepo.findById(id).orElse(null);
    }

    public void deleteProdById(int id) {
        productRepo.deleteById(id);
    }
}
