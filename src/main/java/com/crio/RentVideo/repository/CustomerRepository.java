package com.crio.RentVideo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.crio.RentVideo.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Long> {

    UserDetails findByEmail(String email);

}
