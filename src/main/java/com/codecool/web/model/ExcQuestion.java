package com.codecool.web.model;

import java.util.Random;

public class ExcQuestion {

    private String description;
    private int point;
    private String answer;
    private int id;

    public ExcQuestion(String description, int point) {
        this.description = description;
        this.point = point;
        Random rnd = new Random();
        this.id = rnd.nextInt(90000) + 10000;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
