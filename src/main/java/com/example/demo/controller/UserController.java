package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        // Convert DTO to UserModel and register
        UserModel user = userService.register(request.toUser());

        // Generate JWT token
        String token = jwtUtil.generateToken(user);

        // Return token + user info
        return new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        // Find user by email
        UserModel user = userService.findByEmail(request.getEmail());

        // Check password
        if (!BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Generate JWT token
        String token = jwtUtil.generateToken(user);

        // Return token + user info
        return new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());
    }
}
