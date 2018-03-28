package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;

public class Question {

    //fields
    private String description;
    private int point;
    private List<Answer> answers = new ArrayList<>();
    private String goodAnswer;

    //Constructor
    public Question(String description, int point, List<Answer> answers, String goodAnswer) {
        this.description = description;
        this.point = point;
        this.answers = answers;
        this.goodAnswer = goodAnswer;
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
}
