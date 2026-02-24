package com.ecom_project.shopify.service;

import com.ecom_project.shopify.model.Payment;
import com.ecom_project.shopify.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    PaymentRepo paymentRepo;

    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    public Payment getPaymentById(Integer id) {
        return paymentRepo.findById(id).orElse(null);
    }

    public void addPayment(Payment payment) {
        paymentRepo.save(payment);
    }

    public void deletePayment(Integer id) {
        paymentRepo.deleteById(id);
    }
}
