package com.ecom_project.shopify.repository;

import com.ecom_project.shopify.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
     Optional<Users> findByUserName(String username);
}
