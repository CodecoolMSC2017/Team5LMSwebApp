package com.codecool.web.model;

public class Quiz {

    private String question;
    private String answer;
    private String possibleAnswer1;
    private String possibleAnswer2;
    private String possibleAnswer3;
    private int maxScore;

    public Quiz(String question, String answer,String possibleAnswer1, String possibleAnswer2,
                String possibleAnswer3, int maxScore) {
        this.question = question;
        this.answer = answer;
        this.possibleAnswer1 = possibleAnswer1;
        this.possibleAnswer2 = possibleAnswer2;
        this.possibleAnswer3 = possibleAnswer3;
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

    public String getPossibleAnswer1() {
        return possibleAnswer1;
    }

    public void setPossibleAnswer1(String possibleAnswer1) {
        this.possibleAnswer1 = possibleAnswer1;
    }

    public String getPossibleAnswer2() {
        return possibleAnswer2;
    }

    public void setPossibleAnswer2(String possibleAnswer2) {
        this.possibleAnswer2 = possibleAnswer2;
    }

    public String getPossibleAnswer3() {
        return possibleAnswer3;
    }

    public void setPossibleAnswer3(String possibleAnswer3) {
        this.possibleAnswer3 = possibleAnswer3;
    }
}
