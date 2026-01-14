package com.axios.credit.auth.controller;

import com.axios.credit.auth.model.User;
import com.axios.credit.auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {

        User user = authService.registerUser(
                request.getFullName(),
                request.getPhoneNumber(),
                request.getRole()
        );

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
