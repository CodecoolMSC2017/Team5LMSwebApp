package com.codecool.web.model;

public class Assignment {

    private int number;
    private String title;
    private String description;

    public Assignment(int number, String title, String description) {
        this.number = number;
        this.title = title;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
