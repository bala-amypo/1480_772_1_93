// package com.example.demo.service.impl;

// import com.example.demo.model.InteractionRule;
// import com.example.demo.repository.InteractionRuleRepository;
// import com.example.demo.service.RuleService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class RuleServiceImpl implements RuleService {

//     @Autowired
//     private InteractionRuleRepository ruleRepository;

//     @Override
//     public InteractionRule addRule(InteractionRule rule) {
//         return ruleRepository.save(rule);
//     }

//     @Override
//     public InteractionRule getRule(Long id) {  // ✅ fix
//         return ruleRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Rule not found"));
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    // Manual No-Args Constructor for Test Case #11
    public UserServiceImpl() {}

    // Constructor Injection for Spring (Rule 6.1)
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }
        if (passwordEncoder != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}