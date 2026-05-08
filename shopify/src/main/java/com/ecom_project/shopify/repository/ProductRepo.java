package com.ecom_project.shopify.repository;

import com.ecom_project.shopify.model.Product;
import com.ecom_project.shopify.util.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
        Product findByName(String name);

        List<Product> findByCategory(Category category);
}
