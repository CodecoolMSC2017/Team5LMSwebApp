package com.codecool.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Attendance {

    private List<Registration> currentStudents;
    private String title;

    public Attendance(List<Registration> currentStudents) {
        this.currentStudents = currentStudents;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.title = formatter.format(date);
    }

    public List<Registration> getCurrentStudents() {
        return currentStudents;
    }
    public String getTitle() {
        return title;
    }

    public void setCurrentStudents(List<Registration> currentStudents) {
        this.currentStudents = currentStudents;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
