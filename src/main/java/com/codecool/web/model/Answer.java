package com.codecool.web.model;

import java.util.Random;

public class Answer {
    //filed
    public String name;
    public int id;

    //Constructor

    public Answer(String name) {

        this.name = name;
        Random rnd = new Random();
        this.id = rnd.nextInt(90000) + 10000;
    }

    //Setters/Getters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
