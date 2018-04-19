package com.codecool.web.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Quiz extends Task{

    //fields
    private String date;
    private int maxPoint = 0;
    private List<Question> questions = new ArrayList<>();
    private int time;



    //Constructor
    public Quiz(String title, String description) {
        super(title, description);
        java.util.Date date = new Date( );
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
        this.date = sdf.format(date);
    }


    public Quiz(int id,String title,String description,int time,int  categoryId) {
        super(id, title, description, categoryId);
        java.util.Date date = new Date( );
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
        this.date = sdf.format(date);
        this.time = time;
    }
    //Getters/SEtters


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMaxPoint() {
        int counter = 0;
        for(Question q:this.questions){
            counter += q.getPoint();
        }
        return counter;
    }

    public List<Question> getQuestions() {
        return questions;
    }

}
