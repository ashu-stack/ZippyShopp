package com.ecom_project.shopify.service;

import com.ecom_project.shopify.dto.LoginRequestDto;
import com.ecom_project.shopify.dto.LoginResponseDto;
import com.ecom_project.shopify.dto.SignupRequestDto;
import com.ecom_project.shopify.dto.SignupResponseDTO;
import com.ecom_project.shopify.model.Customer;
import com.ecom_project.shopify.repository.CustomerRepo;
import com.ecom_project.shopify.util.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final AuthUtil authUtil;

    private final CustomerRepo customerRepo;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto loginRequestDto){

       Authentication authentication =  authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),loginRequestDto.getPassword())
       );
        Customer customer = (Customer)authentication.getPrincipal();
        String token = authUtil.generateAccessToken(customer);
        return new LoginResponseDto(token,customer.getUsername());
    }

    public SignupResponseDTO signUp(SignupRequestDto signUpRequestDto) {
        Customer customer = customerRepo.findByEmail(signUpRequestDto.getEmail()).orElse(null);
        if(customer != null) throw new IllegalArgumentException("User already exists");

        Customer customer1 = customerRepo.save(Customer.builder().name(signUpRequestDto.getUsername())
                        .lastName(signUpRequestDto.getLastName())
                .email(signUpRequestDto.getEmail())
                .password(passwordEncoder.encode(signUpRequestDto.getPassword()))
                .build());

        return new SignupResponseDTO(customer1.getId(),customer1.getUsername());

    }

    public ResponseEntity<LoginResponseDto> handleOAuth2LoginRequest(OAuth2User oAuth2User, String registrationId) {
        return null;
    }
}
