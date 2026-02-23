package com.ecom_project.shopify.service;

import com.ecom_project.shopify.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentRepo paymentRepo;
}
