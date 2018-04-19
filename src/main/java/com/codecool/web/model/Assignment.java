package com.codecool.web.model;

public class Assignment extends Task{

    //fields
    private int time;
    private String fullDescription;
    private int id;
    private int categoryId;

    //Constructor
    public Assignment(String title, String description, int time, String fullDescription) {
        super(title, description);
        this.time = time;
        this.fullDescription = fullDescription;
    }

    public Assignment(int id, String title, String description, int time, String fullDescription, int categoryId) {
        super(title, description);
        this.id = id;
        this.time = time;
        this.fullDescription = fullDescription;
        this.categoryId = categoryId;

    }

    //Getters
    public int getTime() {
        return time;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }
}
