package com.codecool.web.model;

public final class Login {

    private String name;
    private String email;
    private String password;
    private String message;

    public Login(String name, String email, String password, String message) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
