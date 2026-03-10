package com.ecom_project.shopify.service;

import com.ecom_project.shopify.model.*;
import com.ecom_project.shopify.repository.CartRepo;
import com.ecom_project.shopify.repository.CustomerRepo;
import com.ecom_project.shopify.repository.OrderRepo;
import com.ecom_project.shopify.repository.PaymentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService implements UserDetailsService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CartRepo cartRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    CartService cartService;



    @Transactional
    public Orders makeOrder(Cart cart){

        int amount = 0;
        for(Product product : cart.getProductList()){
            amount = amount + product.getPrice();
        }
        UUID custId = cart.getCustomerId();
        String modeOfPayment = cart.getModeOfPayment();
        Customer customer = (Customer) customerRepo.findById(custId).orElse(null);
        Orders orders = Orders.builder().custId(custId).amount(amount).orderDate(LocalDate.now()).customer(customer).build();
        orderRepo.save(orders);

        Payment payment = Payment.builder().type(modeOfPayment).customer(customer).amount(amount).build();
        paymentRepo.save(payment);
        return orders;
    }


    public List<Customer> getAllCustomers() {
       return customerRepo.findAll();
    }

    public Customer getCustomerById(UUID id) {
        return (Customer) customerRepo.findById(id).orElse(null);
    }

    public void addCustomer(Customer customer) {
        customerRepo.save(customer);

        Customer customer1 = customerRepo.findByEmail(customer.getEmail());
        Cart cart = Cart.builder().customerId(customer1.getId()).modeOfPayment("COD").productList(new ArrayList<>()).build();
        cartService.createCartForCustomer(cart);

    }


    public void deleteCustomer(UUID id) {
        customerRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepo.findByName(username).orElseThrow();
    }
}
