package com.codecool.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Attendance {

    private String[] currentStudents;
    private String title = formattedCurrentDate();

    public Attendance(String[] currentStudents, String title) {
        this.currentStudents = currentStudents;
        this.title = formattedCurrentDate();
    }

    public String formattedCurrentDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public String[] getCurrentStudents() {
        return currentStudents;
    }

    public String getTitle() {
        return title;
    }

    public void setCurrentStudents(String[] currentStudents) {
        this.currentStudents = currentStudents;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
