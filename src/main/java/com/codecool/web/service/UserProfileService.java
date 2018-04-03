package com.codecool.web.service;

import com.codecool.web.model.Mentor;
import com.codecool.web.model.Registration;
import com.codecool.web.model.SingletonDataBase;
import com.codecool.web.model.Student;

public class UserProfileService {
    Mentor mentor;
    Student student;
    String role;
    Registration registration = SingletonDataBase.getInstance().getLogin().getReg();

    public String getRole(){
        if (registration instanceof Mentor){
            role = "Mentor";
            return role;

        } else {
            role = "Student";
            return role;
        }
    }

    public Registration getReg(){

        if (registration instanceof Mentor){
            mentor = (Mentor) registration;
            return mentor;

        } else {
            student = (Student) registration;
            return student;
        }
    }



}
