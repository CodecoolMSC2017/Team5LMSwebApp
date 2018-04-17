package com.codecool.web.service;

import com.codecool.web.model.Registration;

public interface RegistrationService {

    Registration getReg(String name, String email, String password, String firstName, String lastName);
    Registration getProfile(String id);

}
