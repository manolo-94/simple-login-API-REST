package com.yukode.simpleloginapirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Configure authorization rules
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll() // Allow public access to /api/auth/*
                //.requestMatchers("/api/auth/register", "/api/auth/login").permitAll() // Allow public access to registration and login
                .requestMatchers("/swagger-ui/**").permitAll() // Allow access to Swagger UI
                .requestMatchers("/v3/api-docs/**").permitAll() // Allow access to OpenAPI docs
                .anyRequest().authenticated() // Require authentication for all other endpoints
                )
                .csrf(csrf -> csrf.disable()); // Disable CSRF protection for simplicity (use with caution)

        return http.build();

    }

}
