package com.codecool.web.model;

public class Registration {
    //fields
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String message;
    private String role;
    private int attendance;

    //Constructor
    public Registration(String name, String email, String password, String firstName, String lastName) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.attendance = 10;
        this.role = "Student";

    }

    //Getters, Setters
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole(){
        return role;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAttendance() {
        return String.format("%.2f", (float)attendance/SingletonDataBase.getInstance().getGlobalAttandance()*100);
    }

    public void setAttendance(int attendance) {
        this.attendance += attendance;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
