package com.axios.credit.auth.controller;

public class RegisterRequest {

    private String fullName;
    private String phoneNumber;
    private String role;

    public RegisterRequest() {
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }
}
