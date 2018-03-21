package com.codecool.web.model;

public final class Login {

    private String name;
    private String email;
    private String password;
    private String role;
    private String message;

    public Login(String name, String email, String password, String role,  String message) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
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

    public String getRole() {
        return role;
    }
}
