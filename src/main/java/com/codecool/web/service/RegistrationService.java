package com.codecool.web.service;

import com.codecool.web.model.Registration;

public final class RegistrationService {

    public Registration getReg(String name, String email, String password, String firstName, String lastName) {

        return new Registration(name, email, password, firstName, lastName);
    }
}
