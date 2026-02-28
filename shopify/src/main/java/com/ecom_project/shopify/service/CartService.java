package com.ecom_project.shopify.service;

import com.ecom_project.shopify.model.Cart;
import com.ecom_project.shopify.model.Product;
import com.ecom_project.shopify.repository.CartRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartService {

    CartRepo cartRepo;

    public Cart getCartByCustomerId(UUID custId) {
        return cartRepo.findByCustomerId(custId);
    }
}
