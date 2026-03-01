package com.ecom_project.shopify;

import com.ecom_project.shopify.model.Cart;
import com.ecom_project.shopify.model.Orders;
import com.ecom_project.shopify.model.Product;
import com.ecom_project.shopify.service.CartService;
import com.ecom_project.shopify.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class ShopifyApplicationTests {
	@Autowired
	CustomerService customerService;

	@Autowired
	CartService cartService;

	@Test
	void checkMakePaymentMethod() {
		Product product = Product.builder().name("Laptop").price(50000).available(true).build();
		Product product1 = Product.builder().name("Ipad").price(40000).available(true).build();

		List<Product> list = List.of(product,product1);

		List<Product> products = null;
		UUID custId = UUID.fromString("550e8400-e29b-41d4-a716-446655440000");
		String paymentMode = "COD";

		// Orders orders = customerService.makeOrder(list,custId,paymentMode);
		//System.out.println(orders);

	}

	@Test
	void testAddToCart(){
		Product product = Product.builder().name("Laptop").price(50000).available(true).build();
		UUID custId = UUID.fromString("550e8400-e29b-41d4-a716-446655440000");
		Cart cart = cartService.addToCart(product,custId);
		System.out.println(cart);

	}

	@Test
	void testRemoveFromCart(){
		Product product = Product.builder().name("Laptop").price(50000).available(true).build();
		UUID custId = UUID.fromString("550e8400-e29b-41d4-a716-446655440000");
		Cart cart = cartService.removeFromCart(product,custId);
		System.out.println(cart);
	}

}
