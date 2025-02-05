package com.crio.RentVideo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crio.RentVideo.controller.exchanges.request.AuthRequest;
import com.crio.RentVideo.controller.exchanges.request.RegisterRequest;
import com.crio.RentVideo.controller.exchanges.response.AuthResponse;
import com.crio.RentVideo.model.Customer;
import com.crio.RentVideo.model.enums.Role;
import com.crio.RentVideo.repository.CustomerRepository;

@Service
public class AuthService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CustomerRepository customerRepository; 

    @Autowired 
    AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        if (request.getRole() == null) {
            request.setRole(Role.CUSTOMER);
        }

        Customer customer = Customer.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        customerRepository.save(customer);

        return AuthResponse.builder().build();

    }

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()));
        return AuthResponse.builder().build();
    }
}
