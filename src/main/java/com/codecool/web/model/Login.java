package com.codecool.web.model;

public final class Login {
    //fields
    private Registration reg;
    private String message;

    //Constructors
    public Login(Registration reg, String message) {
        this.reg = reg;
        this.message = message;
    }

    public Login(String message){
        this.message = message;
    }

    //Getters, Setters
    public Registration getReg() {
        return reg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setReg(Registration reg) {
        this.reg = reg;
    }
}
