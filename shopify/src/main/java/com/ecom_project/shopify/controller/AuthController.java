package com.ecom_project.shopify.controller;

import com.ecom_project.shopify.dto.LoginRequestDto;
import com.ecom_project.shopify.dto.LoginResponseDto;
import com.ecom_project.shopify.dto.SignupRequestDto;
import com.ecom_project.shopify.dto.SignupResponseDTO;
import com.ecom_project.shopify.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(authService.login(loginRequestDto));

    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDTO> login(@RequestBody SignupRequestDto signupRequestDto){
        return ResponseEntity.ok(authService.signup(signupRequestDto));

    }
}
