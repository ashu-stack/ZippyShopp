package com.ecom_project.shopify.service;

import com.ecom_project.shopify.dto.LoginRequestDto;
import com.ecom_project.shopify.dto.LoginResponseDto;
import com.ecom_project.shopify.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    public LoginResponseDto login(LoginRequestDto loginRequestDto){

       Authentication authentication =  authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),loginRequestDto.getPassword())
       );
        Customer customer = (Customer)authentication.getPrincipal();
    }
}
