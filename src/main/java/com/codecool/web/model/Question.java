package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Question {

    //fields
    private String description;
    private int point;
    private List<Answer> answers = new ArrayList<>();
    private String goodAnswer;
    private int id;

    //Constructor
    public Question(String description, int point, List<Answer> answers, String goodAnswer) {
        this.description = description;
        this.point = point;
        this.answers = answers;
        this.goodAnswer = goodAnswer;
        Random rnd = new Random();
        this.id = rnd.nextInt(90000)+10000;
    }

    //Getters/SEtters

    public String getDescription() {
        return description;
    }

    public int getPoint() {
        return point;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String getGoodAnswer() {
        return goodAnswer;
    }

    public int getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGoodAnswer(String goodAnswer) {
        this.goodAnswer = goodAnswer;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
