package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;

public class AandQStore {

    //fields
    private String title;
    private List<Assignment> assignments = new ArrayList<>();
    private List<Quiz> quizzes = new ArrayList<>();

    //Constructors
    public AandQStore(String title){
        this.title = title;
    }

    //Setters/Getters

    public String getTitle() {
        return title;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }
}
