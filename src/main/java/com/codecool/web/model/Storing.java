package com.codecool.web.model;

import java.util.List;

public interface Storing {

    void newLogin(Login login);
    Login getLogin();
    void delLogin();
    List<Registration> getAllRegistration();
    boolean addRegistration(Registration registration);
    Registration getRegistration(String name);
    void updateReg(String fname, String lname, String email, String pass);
    void deleteReg(Registration registration);
    List<String> getNames();
    List<String> getEmails();
    List<String> getPasswords();
    boolean isMentor(Registration registration);
    List<AandQStore> getaQStores();
    List<Registration> getStudents();
    List<Registration> getMentors();

}
