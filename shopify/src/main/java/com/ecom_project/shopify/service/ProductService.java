package com.ecom_project.shopify.service;

import com.ecom_project.shopify.model.Product;
import com.ecom_project.shopify.repository.ProductRepo;
import java.util.List;

import com.ecom_project.shopify.util.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    private final String cacheName = "products";



    @Cacheable(cacheNames = cacheName, key = "#category")
    public List<Product> getAllProd(Category category) {
        return productRepo.findByCategory(category);
    }


    public void addNewProd(Product product) {
        productRepo.save(product);
    }

    @Cacheable(cacheNames = cacheName, key = "#id")
    public Product getProdById(int id) {
       return productRepo.findById(id).orElse(null);
    }

    public Product getProdByName(String name) {
        return productRepo.findByName(name);
    }

    @CacheEvict(cacheNames = cacheName, key = "#id")
    public void deleteProdById(int id) {
        productRepo.deleteById(id);
    }
}
