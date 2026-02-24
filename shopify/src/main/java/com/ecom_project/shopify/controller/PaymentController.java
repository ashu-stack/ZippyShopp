package com.ecom_project.shopify.controller;

import com.ecom_project.shopify.model.Payment;
import com.ecom_project.shopify.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    //getAll
    @GetMapping("/payment/getAll")
    public List<Payment> getPayments(){
        return paymentService.getAllPayments();
    }

    //get by id
    @GetMapping("/payment/getById/{id}")
    public Payment getPaymentById(@PathVariable Integer id){
        return paymentService.getPaymentById(id);
    }

    // put
    @PostMapping("/payment/addPayment")
    public void addPayment(@RequestBody Payment payment){
        paymentService.addPayment(payment);
    }


    // delete
    @DeleteMapping("/payment/delete/{id}")
    public void deletePaymentById(@PathVariable Integer id){
        paymentService.deletePayment(id);
    }
}
