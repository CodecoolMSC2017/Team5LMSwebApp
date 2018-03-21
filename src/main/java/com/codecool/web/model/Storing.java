package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;

public interface Storing {

    public void newLogin(Login login);
    public Login getLogin();
    public void delLogin();
    public List<Registration> getAllRegistration();
    public boolean addRegistration(Registration registration);
    public Registration getRegistration(String name);
    public void updateReg(Registration registration);
    public void deleteReg(Registration registration);
    public List<String> getNames();
    public List<String> getEmails();
    public List<String> getPasswords();
    public boolean isMentor(Registration registration);
    public List<Assignment> getAssignmentList();

}
