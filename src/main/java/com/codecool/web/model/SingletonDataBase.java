package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;

public class SingletonDataBase implements Storing{

    private static final SingletonDataBase Instance = new SingletonDataBase();

    private List<Registration> registrations = new ArrayList<>();

    public static SingletonDataBase getInstance()
    {
        return Instance;
    }

    private SingletonDataBase() {
    }


    @Override
    public List<Registration> getAllRegistration() {
        return registrations;
    }

    @Override
    public Registration getRegistration(String name) {
        for (Registration registration:registrations){
            if(registration.getName().equals(name));
                return registration;
        }
        return null;
    }

    @Override
    public void updateReg(Registration registration) {

    }

    @Override
    public void deleteReg(Registration registration) {

    }

    @Override
    public boolean addRegistration(Registration registration) {

        if(getNames().contains(registration.getName()) || getEmails().contains(registration.getEmail())){
            return false;
        }else{
            registrations.add(registration);
            return true;
        }
    }

    public List<String> getNames(){
        List<String> names = new ArrayList<>();
        for(Registration registration:registrations){
            names.add(registration.getName());
        }
        return names;
    }

    public List<String> getEmails(){
        List<String> emails = new ArrayList<>();
        for(Registration registration:registrations){
            emails.add(registration.getName());
        }
        return emails;
    }
}
