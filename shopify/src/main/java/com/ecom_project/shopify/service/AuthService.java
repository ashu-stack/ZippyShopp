package com.ecom_project.shopify.service;

import com.ecom_project.shopify.model.Customer;
import com.ecom_project.shopify.repository.CustomerRepo;
import com.ecom_project.shopify.util.AuthUtil;
import com.ecom_project.shopify.dto.LoginRequestDto;
import com.ecom_project.shopify.dto.LoginResponseDto;
import com.ecom_project.shopify.dto.SignupRequestDto;
import com.ecom_project.shopify.dto.SignupResponseDTO;
import com.ecom_project.shopify.model.Users;
import com.ecom_project.shopify.repository.UserRepository;
import com.ecom_project.shopify.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthUtil authUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder encoder;

    public LoginResponseDto login(LoginRequestDto loginRequestDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );

        Users users = (Users) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(users);
        return new LoginResponseDto(token, users.getUsername());
    }


    public SignupResponseDTO signup(SignupRequestDto signupRequestDto) {
        Users users = userRepository.findByUserName(signupRequestDto.getUsername()).orElse(null);

        if(users != null) {
            throw new IllegalArgumentException("User exists");
        }

        String encoded = passwordEncoder.encode(signupRequestDto.getPassword());
        System.out.println("ENCODED: " + encoded);


        users = userRepository.save(Users.builder()
                .userName(signupRequestDto.getUsername())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .email(signupRequestDto.getEmail())
                .role(Collections.singleton(Role.STAFF))
                .build());

         Customer customer = Customer.builder().name(signupRequestDto.getUsername()).email(signupRequestDto.getEmail())
                .password(signupRequestDto.getPassword()).build();

         customerService.addCustomer(customer);

        return new SignupResponseDTO(users.getId(), users.getUsername());

    }
}
