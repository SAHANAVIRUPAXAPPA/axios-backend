package com.axios.credit.auth.service;

import com.axios.credit.auth.model.User;
import com.axios.credit.auth.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String fullName, String phoneNumber, String role) {

        if (userRepository.existsByPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Phone number already registered");
        }

        User user = new User(fullName, phoneNumber, role);
        return userRepository.save(user);
    }
}
