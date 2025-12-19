package com.example.demo.service;

import com.example.demo.model.UserModel;

public interface UserService {
    UserModel register(UserModel user);
    UserModel login(UserModel user);
}
