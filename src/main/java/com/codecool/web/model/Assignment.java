package com.codecool.web.model;

public class Assignment extends Task{

    //fields
    private int time;
    private String fullDescription;

    //Constructor
    public Assignment(String title, String description, int time, String fullDescription) {
        super(title, description);
        this.time = time;
        this.fullDescription = fullDescription;
    }

    //Getters
    public int getTime() {
        return time;
    }

    public String getFullDescription() {
        return fullDescription;
    }
}
