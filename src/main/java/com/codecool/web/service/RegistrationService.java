package com.codecool.web.service;

import com.codecool.web.model.Registration;

public final class RegistrationService {

    public Registration registration(String name, String email, String password, String confirmPassword, String role) {
        String message = "";

//        if ( name == "" ) { message += "Missing: name\n"; }
//        if ( email == "" )  { message += "Missing: e-mail address\n"; }
//        if ( password == "" ) { message += "Missing: password\n"; }
        if ( confirmPassword != password ) { message += "Password does not match the confirm password.\n"; }
//        if ( role == "" ) { message += "Missing: role"; }

        else message = "Successfully registered";

        return new Registration(name, email, password, confirmPassword, role, message);
    }
}
