package com.codecool.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Attendance {

    //fields
    private int id;
    private List<Registration> currentStudents;
    private List<Registration> currentStudentsId;
    private String title;

    //Const.
    public Attendance(List<Registration> currentStudents) {
        this.currentStudents = currentStudents;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.title = formatter.format(date);
    }

    public Attendance(int id, String title, List<Registration> currentStudentsId) {
        this.id = id;
        this.currentStudentsId = currentStudentsId;
        this.title = title;
    }

    //getters setters
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
