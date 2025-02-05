package com.crio.RentVideo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.crio.RentVideo.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    UserDetails findByEmail(String email);

}
