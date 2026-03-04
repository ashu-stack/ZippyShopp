package com.ecom_project.shopify.controller;

import com.ecom_project.shopify.model.Cart;
import com.ecom_project.shopify.model.Product;
import com.ecom_project.shopify.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    private Cart cart;

    @GetMapping("/cart/showItems")
    public Cart showCart(UUID custId){
        cart = cartService.getCartByCustomerId(custId);
        return cart;
    }

    // add item
    @PostMapping("/cart/addItem/{productId}/{custId}")
    public Cart addItem(@PathVariable Integer productId, @PathVariable UUID custId){
        cart = cartService.addToCart(productId,custId);
        return cart;
    }


    // remove item
    @DeleteMapping("/cart/removeItem/{productId}/{custId}")
    public Cart removeItem(@PathVariable Integer productId, @PathVariable UUID custId){

        cart = cartService.removeFromCart(productId,custId);

        return cart;
    }

}
