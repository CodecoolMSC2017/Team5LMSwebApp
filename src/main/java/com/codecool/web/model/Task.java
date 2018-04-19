package com.codecool.web.model;

import java.util.Random;

public abstract class Task {

    //fields
    private String title;
    private String description;
    private int id;
    private int categoryId;
    private boolean isPublished;

    //Constructor
    public Task( String title, String description){
        Random rnd = new Random();
        this.id = rnd.nextInt(9000) + 1000;
        this.title = title;
        this.description = description;
        this.isPublished = false;
    }

    public Task(int id, String title, String description, int categoryId){
        this.id = id;
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
        this.isPublished = false;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
