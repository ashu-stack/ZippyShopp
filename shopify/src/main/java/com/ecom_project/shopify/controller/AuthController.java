package com.ecom_project.shopify.controller;

import com.ecom_project.shopify.dto.LoginRequestDto;
import com.ecom_project.shopify.dto.LoginResponseDto;
import com.ecom_project.shopify.dto.SignupRequestDto;
import com.ecom_project.shopify.dto.SignupResponseDTO;
import com.ecom_project.shopify.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
       LoginResponseDto loginResponseDto = authService.login(loginRequestDto);
       return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDTO> signUp(@RequestBody SignupRequestDto signUpRequestDto){

        return ResponseEntity.ok(authService.signUp(signUpRequestDto));
    }


}
