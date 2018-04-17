package com.codecool.web.model;

import java.util.HashMap;

public class Registration {
    //fields
    private int id;
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String message;
    private String role;
    private float attendance;
    private HashMap<Integer, Integer> quizResult = new HashMap<>();


    //Constructor
    public Registration(String name, String email, String password, String firstName, String lastName) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = "Student";
    }

    public Registration(int id, String name, String email, String password, String firstName, String lastName, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
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

    public void setRole(String role) {
        this.role = role;
    }

    public float getAttendance() {
        return attendance;
    }

    public void setAttendance(float attendance) {
        this.attendance = attendance;
    }

    public HashMap<Integer, Integer> getQuizResult() {
        return quizResult;
    }

    public void setQuizResult(HashMap<Integer, Integer> quizResult) {
        this.quizResult = quizResult;
    }
}
