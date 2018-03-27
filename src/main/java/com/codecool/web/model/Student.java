package com.codecool.web.model;

import java.util.Map;

public class Student extends Registration {
    //fields
    private int attendance;
    private Map<Integer, Quiz> results;

    //Constructor
    public Student(String name, String email, String password, String firstName, String lastName) {
        super(name, email, password, firstName, lastName);
        this.attendance = 10;
    }

    //Getters, Setters
    public String getAttendance() {
        return String.format("%.2f", (float)attendance/SingletonDataBase.getInstance().getGlobalAttandance()*100);
    }

    public void setAttendance(int attendance) {
        this.attendance += attendance;
    }

    public Map<Integer, Quiz> getResults() { return results; }

    public void setResults(Map<Integer, Quiz> results) { this.results = results; }
}
