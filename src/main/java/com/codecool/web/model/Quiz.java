package com.codecool.web.model;

public class Quiz {

    private String question;
    private String answer;
    private int maxScore;

    public Quiz(String question, String answer, int maxScore) {
        this.question = question;
        this.answer = answer;
        this.maxScore = maxScore;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
}
