package com.codecool.web.model;

import java.util.List;

public interface Storing {

    void newLogin(Login login);
    Login getLogin();
    void delLogin();
    List<Registration> getAllRegistration();
    boolean addRegistration(Registration registration);
    Registration getRegistration(String name);
    void updateReg(Login Login, String name, String fname, String lname, String pass, String confPass);
    void deleteReg(Registration registration);
    List<String> getNames();
    List<String> getEmails();
    List<String> getPasswords();
    boolean isMentor(Registration registration);
    List<Assignment> getAssignmentList();

}
