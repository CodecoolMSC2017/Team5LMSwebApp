package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;

public class Exercise extends Task {

    private int maxPoint = 0;
    private List<Question> excQuestions = new ArrayList<>();

    public Exercise(String title, String description) {
        super(title, description);
    }

    public int getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(int maxPoint) {
        this.maxPoint = maxPoint;
    }

    public List<Question> getExcQuestions() {
        return excQuestions;
    }

    public void setExcQuestions(List<Question> excQuestions) {
        this.excQuestions = excQuestions;
    }
}
