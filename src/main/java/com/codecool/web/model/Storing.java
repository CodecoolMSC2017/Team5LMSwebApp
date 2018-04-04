package com.codecool.web.model;

import java.util.List;

public interface Storing {

    List<Registration> getAllRegistration();
    boolean addRegistration(Registration registration);
    Registration getRegistration(String name);
    Registration updateReg(Registration reg, String fname, String lname, String email, String pass);
    void deleteReg(Registration registration);
    List<String> getNames();
    List<String> getEmails();
    List<String> getPasswords();
    List<AandQStore> getaQStores();
    List<Registration> getStudents();
    List<Registration> getMentors();

}
