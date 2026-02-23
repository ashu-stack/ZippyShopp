package com.ecom_project.shopify.controller;

import com.ecom_project.shopify.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
}
