package com.ecom_project.shopify.util;

import com.ecom_project.shopify.model.Customer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class AuthUtil {

    @Value("${jwt.secretKey}")
    private String secretKey;

    private SecretKey secretKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccessToken(Customer customer){
        return Jwts.builder()
                .subject(customer.getName())
                .claim("custId", customer.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+ 1000*60*10))
                .signWith(secretKey())
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(secretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }
}
