package com.ecom_project.shopify.util;

import com.ecom_project.shopify.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class AuthUtil {

    @Value("${jwt.secretKey}")
    private String secretKey;

    private SecretKey secretKey(){
        return null;
    }

    private String generateAccessToken(Customer customer){
        return "";
    }

}
