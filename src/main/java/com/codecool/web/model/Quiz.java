package com.codecool.web.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Quiz extends Task{

    //fields
    private String date;
    private int maxPoint;
    private List<Question> questions = new ArrayList<>();
    private int id;

    //Constructor
    public Quiz(String title, String description, int maxPoint, int id) {
        super(title, description);
        java.util.Date date = new Date( );
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy.MM.dd");
        this.date = sdf.format(date);
        this.maxPoint = maxPoint;
        this.id = id;

    }

    //Getters/SEtters


    public String getDate() {
        return date;
    }

    public int getMaxPoint() {
        return maxPoint;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
