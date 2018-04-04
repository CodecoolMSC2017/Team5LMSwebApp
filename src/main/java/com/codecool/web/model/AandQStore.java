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

    public AandQStore(AandQStore original) {
        this.title = original.title;
        this.assignments = new ArrayList<>(original.assignments);
        this.quizzes = new ArrayList<>(original.quizzes);
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

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}
