package com.codecool.web.service;

import com.codecool.web.model.Registration;

import java.sql.SQLException;

public interface RegistrationService {

    Registration getReg(String name, String email, String password, String firstName, String lastName);
    Registration getProfile(String id) throws SQLException;

}
