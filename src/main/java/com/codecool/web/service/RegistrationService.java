package com.codecool.web.service;

import com.codecool.web.model.Mentor;
import com.codecool.web.model.Registration;
import com.codecool.web.model.Student;

public final class RegistrationService {

    public Registration getMentor(String name, String email, String password, String firstName, String lastName) {

        return new Mentor(name, email, password,firstName,lastName);
    }

    public Registration getStudent(String name, String email, String password, String firstName, String lastName) {

        return new Student(name, email, password, firstName,lastName);
    }
}
