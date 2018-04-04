package com.codecool.web.model;

import java.util.Random;

public abstract class Task {

    //fields
    private String title;
    private String description;
    private int id;
    private boolean isPublished;

    //Constructor
    public Task( String title, String description){
        Random rnd = new Random();
        this.id = rnd.nextInt(9999) + 1000;
        this.title = title;
        this.description = description;
        this.isPublished = true;
    }

    //Setters/Getters

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }
}
