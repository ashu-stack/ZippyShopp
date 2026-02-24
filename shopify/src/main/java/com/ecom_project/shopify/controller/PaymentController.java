package com.ecom_project.shopify.controller;

import com.ecom_project.shopify.model.Payment;
import com.ecom_project.shopify.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    //getAll
    @GetMapping("/payment/getAll")
    public ResponseEntity<List<Payment>> getPayments(){
        List<Payment> list = paymentService.getAllPayments();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //get by id
    @GetMapping("/payment/getById/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Integer id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new ResponseEntity<>(payment, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // put
    @PostMapping("/payment/addPayment")
    public ResponseEntity addPayment(@RequestBody Payment payment){
        paymentService.addPayment(payment);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    // delete
    @DeleteMapping("/payment/delete/{id}")
    public ResponseEntity deletePaymentById(@PathVariable Integer id){
        paymentService.deletePayment(id);
        return new ResponseEntity(HttpStatus.GONE);
    }
}
