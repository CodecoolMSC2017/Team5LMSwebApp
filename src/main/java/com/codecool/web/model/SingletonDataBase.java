package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;

public class SingletonDataBase implements Storing {

    private static final SingletonDataBase Instance = new SingletonDataBase();

    private List<Registration> registrations = new ArrayList<>();
    private List<Assignment> assignmentList = new ArrayList<>();
    private Login login;

    public static SingletonDataBase getInstance() {
        return Instance;
    }

    private SingletonDataBase() {
    }


    @Override
    public void newLogin(Login login) {
        this.login = login;
    }

    @Override
    public Login getLogin() {
        return null;
    }

    @Override
    public void delLogin(){
        this.login = null;
    }

    @Override
    public List<Registration> getAllRegistration() {
        return registrations;
    }

    @Override
    public Registration getRegistration(String name) {
        for (Registration registration : registrations) {
            if (registration.getName().equals(name)) ;
            return registration;
        }
        return null;
    }

    @Override
    public void updateReg(Registration registration) {
        String newName = new String();
        String newPass = new String();
        String newRole = new String();
        registration.setName(newName);
        registration.setPassword(newPass);
        registration.setRole(newRole);

    }

    @Override
    public void deleteReg(Registration registration) {
        registrations.remove(registration);
    }

    @Override
    public boolean addRegistration(Registration registration) {

        if(getNames().contains(registration.getName()) || getEmails().contains(registration.getEmail())){
            registration.setMessage("The name/password already exist, create a new one");
            return false;
        }else{
            registrations.add(registration);
            return true;
        }
    }

    @Override
    public List<String> getNames(){
        List<String> names = new ArrayList<>();
        for(Registration registration:registrations){
            names.add(registration.getName());
        }
        return names;
    }

    @Override
    public List<String> getEmails(){
        List<String> emails = new ArrayList<>();
        for(Registration registration:registrations){
            emails.add(registration.getName());
        }
        return emails;
    }

    @Override
    public List<String> getPasswords() {
        List<String> passes = new ArrayList<>();
        for (Registration registration : registrations) {
            passes.add(registration.getName());
        }
        return passes;
    }

    @Override
    public boolean isMentor(Registration registration) {
        if(registration.getRole().equals("mentor")) {
            return true;
        }
        return false;
    }

    @Override
    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public Assignment firstAssignment = new Assignment(1,"Learn Python", "Check Sololearn");
}
