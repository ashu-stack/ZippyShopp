package com.ecom_project.shopify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth
                               // .requestMatchers("/admin/**").hasRole("ADMIN")
                        //.requestMatchers("/user/**").hasAnyRole("ADMIN","MANAGER")
                        .anyRequest().authenticated())
                //.authorizeHttpRequests(auth -> auth.requestMatchers("/user/**").hasAnyRole("ADMIN", "MANAGER"))
                //.authorizeHttpRequests(auth -> auth.anyRequest()
                //.authenticated())
                .formLogin(Customizer.withDefaults()) // Login page UI
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

//    @Bean
//    @Primary
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User.withUsername("ashu").
//                                    password(passwordEncoder().encode("goat")).
//                                    roles("ADMIN").build();
//        UserDetails user2 = User.withUsername("soham")
//                                .password(passwordEncoder().encode("goatjr"))
//                                .roles("USER").build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
