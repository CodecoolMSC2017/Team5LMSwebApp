package com.codecool.web.service;

import com.codecool.web.model.Registration;

public final class RegistrationService {

    public Registration registrate(String name, String email) {
        String message = "Successfully registered!";
        if (name.equals("") || email.equals("")) {
            message = "Registration Failed!";
        }
        return new Registration(name, email, message);
    }
}
