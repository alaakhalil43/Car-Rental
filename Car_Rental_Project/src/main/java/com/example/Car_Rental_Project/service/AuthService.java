package com.example.Car_Rental_Project.service;

import com.example.Car_Rental_Project.dto.SignupRequest;
import com.example.Car_Rental_Project.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);
    boolean duplicatedEmail(String email);
}
