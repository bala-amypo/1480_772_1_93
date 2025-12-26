package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // Demo user (replace with DB later)
        if ("admin".equals(username)) {
            return new CustomUserDetails(
                    "admin",
                    "$2a$10$7Z4zJXx1y8PZpQz8QJ2BDe6m2XbLrHq1p9N5U9WZp1QmOqGzG"
            );
        }
        throw new UsernameNotFoundException("User not found");
    }
}
