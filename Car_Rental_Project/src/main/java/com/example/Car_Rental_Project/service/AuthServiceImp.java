package com.example.Car_Rental_Project.service;

import com.example.Car_Rental_Project.dto.SignupRequest;
import com.example.Car_Rental_Project.dto.UserDto;
import com.example.Car_Rental_Project.entity.User;
import com.example.Car_Rental_Project.enums.UserRole;
import com.example.Car_Rental_Project.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService{

    private  final UserRepo userRepo;
    @Override
    public UserDto createCustomer(SignupRequest signupRequest) {
        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        user.setUserRole(UserRole.customer);

      User createdUser= userRepo.save(user);
      UserDto userDto=new UserDto();
      user.setId(createdUser.getId());

      return userDto;
    }

    @Override
    public boolean duplicatedEmail(String email) {
        return (userRepo.findByEmail(email).isPresent());
    }

}
