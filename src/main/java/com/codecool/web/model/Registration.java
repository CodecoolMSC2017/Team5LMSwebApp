package com.codecool.web.model;

public final class Registration {

    private String message;
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private String role;

    public Registration(String name, String email, String password, String confirmPassword, String role, String message) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
        this.confirmPassword = confirmPassword;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getRole() {
        return role;
    }

}
