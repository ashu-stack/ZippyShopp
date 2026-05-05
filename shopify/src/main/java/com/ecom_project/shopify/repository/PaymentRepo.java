package com.ecom_project.shopify.repository;


import com.ecom_project.shopify.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Integer> {
    @Override
    Optional<Payment> findById(Integer integer);

}
