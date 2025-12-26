package com.example.demo.service;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User register(User user) { return user; }
    @Override
    public User findByEmail(String email) { return null; }
}
