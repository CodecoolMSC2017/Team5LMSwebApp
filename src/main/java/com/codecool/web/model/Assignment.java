package com.codecool.web.model;

public class Assignment {

    private int number;
    private String title;
    private String description;
    private int maxScore;
    private String task;
    private String answer;

    public Assignment(int number, String title, String description, int maxScore, String task) {
        this.number = number;
        this.title = title;
        this.description = description;
        this.maxScore = maxScore;
        this.task = task;
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

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public void setTask(String question) {
        this.task = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getMaxScore() {

        return maxScore;
    }

    public String getTask() {
        return task;
    }

    public String getAnswer() {
        return answer;
    }
}
