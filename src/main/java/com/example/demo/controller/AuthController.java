package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    // Register user
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        // Hash password manually in controller (since JwtUtil removed)
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole("USER");
        }
        return userService.registerUser(user);
    }

    // Login (simple validation, returns boolean success)
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing == null || !passwordEncoder.matches(user.getPassword(), existing.getPassword())) {
            return "Invalid credentials";
        }
        return "Login successful for user: " + existing.getEmail();
    }
}
