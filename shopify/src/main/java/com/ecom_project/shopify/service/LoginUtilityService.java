package com.ecom_project.shopify.service;

import com.ecom_project.shopify.model.Users;
import com.ecom_project.shopify.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LoginUtilityService implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUserName(username).orElse(null);

        if(user == null){
            throw new UsernameNotFoundException("User : " + username + " not found");
        }

        return user;
    }
}
