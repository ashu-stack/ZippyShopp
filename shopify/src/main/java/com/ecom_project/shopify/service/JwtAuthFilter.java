package com.ecom_project.shopify.service;

import com.ecom_project.shopify.model.Users;
import com.ecom_project.shopify.repository.UserRepository;
import com.ecom_project.shopify.util.AuthUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    AuthUtil authUtil;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LoginUtilityService loginUtilityService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("incoming request: {}" , request.getRequestURI());
        String requestTokenHeader = request.getHeader("Authorization");
        if(requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        try{


        String token = requestTokenHeader.substring(7).trim();
        String username = authUtil.getUserNameFromToken(token);
        if(username != null && SecurityContextHolder.getContext().getAuthentication()== null){

            UserDetails userDetails = loginUtilityService.loadUserByUsername(username);
            if(authUtil.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken token1 = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(token1);
                log.info("AUTH SET FOR USER: {}", username);
            }
        }
        } catch (Exception e) {
            log.error("JWT ERROR: {}", e.getMessage());
        }

        filterChain.doFilter(request,response);
    }
}
