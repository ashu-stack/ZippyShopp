package com.ecom_project.shopify.controller;


import com.ecom_project.shopify.model.Product;
import com.ecom_project.shopify.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @RequestMapping("/")
    public String greet(){
        return "Welcome to Shopify";
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> list =   productService.getAllProd();

        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product =  productService.getProdById(id);
        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/product")
    public ResponseEntity addProduct(@RequestBody Product product){
        productService.addNewProd(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){
        productService.deleteProdById(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
