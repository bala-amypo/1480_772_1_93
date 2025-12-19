package com.example.demo.controller;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // POST /user/register
    @PostMapping("/register")
    public ResponseEntity<UserModel> register(@RequestBody UserModel user) {
        UserModel savedUser = userService.register(user);
        return ResponseEntity.ok(savedUser);
    }

    // POST /user/login
    @PostMapping("/login")
    public ResponseEntity<UserModel> login(@RequestBody UserModel user) {
        UserModel loggedInUser = userService.login(user);
        return ResponseEntity.ok(loggedInUser);
    }
}
