package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AandQStore {

    //fields
    private String title;
    private List<Assignment> assignments = new ArrayList<>();
    private List<Quiz> quizzes = new ArrayList<>();
    private int id;

    //Constructors
    public AandQStore(String title) {

        this.title = title;
        Random rnd = new Random();
        this.id = rnd.nextInt(90000) + 10000;
    }

    public AandQStore(int id, String title) {

        this.id = id;
        this.title = title;
    }

    //Deep copy Constructor
    public AandQStore(AandQStore original) {
        this.title = original.title;
        this.assignments = new ArrayList<>(original.assignments);
        this.quizzes = new ArrayList<>(original.quizzes);
        Random rnd = new Random();
        this.id = rnd.nextInt(90000) + 10000;
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

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
