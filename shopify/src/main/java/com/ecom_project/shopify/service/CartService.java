package com.ecom_project.shopify.service;

import com.ecom_project.shopify.model.Cart;
import com.ecom_project.shopify.model.Product;
import com.ecom_project.shopify.repository.CartRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartService {

    CartRepo cartRepo;

    public Cart getCartByCustomerId(UUID custId) {
        return cartRepo.findByCustomerId(custId);
    }


    @Transactional
    public Cart addToCart(Product product, UUID custId){

        Cart cart = getCartByCustomerId(custId);
        cart.getProductList().add(product);

        int newCount = product.getStock();
        product.setStock(newCount-1);
        return cart;
    }

    @Transactional
    public Cart removeFromCart(Product product, UUID custId){

        Cart cart = getCartByCustomerId(custId);
        cart.getProductList().remove(product);

        int newCount = product.getStock();
        product.setStock(newCount+1);
        return cart;
    }
}
