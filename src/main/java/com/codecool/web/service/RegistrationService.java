package com.codecool.web.service;

import com.codecool.web.model.Registration;

public final class RegistrationService {

    public Registration registration(String name, String email, String password, String confirmPassword, String role) {
        String message;

        if (!(confirmPassword.equals(password))) {
            message = "Password does not match the confirm password.";
        } else {
            message = "Your registration was successful.";
        }

        return new Registration(name, email, password, confirmPassword, role, message);
    }
}
