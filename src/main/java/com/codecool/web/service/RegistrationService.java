package com.codecool.web.service;

import com.codecool.web.model.Registration;

public final class RegistrationService {

    public Registration registrate(String name, String email, String password, String confirmPassword, String role) {
        String message = "Successfully registered!";

        if ( name.equals("") ) {
            message = "Missing name!";
        }
        else if ( email.equals("") ) {
            message = "Missing e-mail address!";
        }
        else if ( password.equals("") ) {
            message = "Missing password!";
        }
//        else if ( !confirmPassword.equals(password) ) {
//            message = "Password does not match the confirm password.";
//        }
        else if ( role.equals("") ) {
            message = "Missing role!";
        }
        return new Registration(name, email, password, confirmPassword, role, message);
    }
}
