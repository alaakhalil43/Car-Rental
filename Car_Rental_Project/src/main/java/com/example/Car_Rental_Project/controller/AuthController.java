package com.example.Car_Rental_Project.controller;

import com.example.Car_Rental_Project.dto.SignupRequest;
import com.example.Car_Rental_Project.dto.UserDto;
import com.example.Car_Rental_Project.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

     @PostMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest){
         if (authService.duplicatedEmail(signupRequest.getEmail()))
             return new ResponseEntity<>("duplicated email", HttpStatus.NOT_ACCEPTABLE);

        UserDto userDto=authService.createCustomer(signupRequest);
        if (userDto==null)
            return new ResponseEntity<>("customer not created", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>("userDto",HttpStatus.CREATED);
    }
}
