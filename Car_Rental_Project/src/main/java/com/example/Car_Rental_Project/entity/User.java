package com.example.Car_Rental_Project.entity;

import com.example.Car_Rental_Project.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    private String password;

    private UserRole userRole;

}
