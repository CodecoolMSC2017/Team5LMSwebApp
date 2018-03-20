package com.codecool.web.service;

import com.codecool.web.model.Login;

public final class LoginService {

    public Login getLogin(String name, String email, String password) {
        String message;
        message = "Login successful :)";
        return new Login(name, email, password, message);
    }
}
