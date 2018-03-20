package com.codecool.web.service;

import com.codecool.web.model.Login;

public final class LoginService {

    public Login getLogin(String name, String email, String password) {
        String message;

        message = "Password does not match the confirm password.";
        message = "Login successful :)";

        return new Login(name, email, password, message);
    }
}
