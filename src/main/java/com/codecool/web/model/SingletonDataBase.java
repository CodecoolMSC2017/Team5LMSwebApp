package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;

public class SingletonDataBase implements Storing {

    private static final SingletonDataBase Instance = new SingletonDataBase();

    private List<Registration> registrations = new ArrayList<>();

    public static SingletonDataBase getInstance() {
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
        for (Registration registration : registrations) {
            if (registration.getName().equals(name)) ;
            return registration;
        }
        return null;
    }

    @Override
    public void updateReg(Registration registration) {
        if (registration.getRole().equalsIgnoreCase("mentor")) {


        }
    }

    @Override
    public void deleteReg(Registration registration) {
        registrations.remove(registration);
    }

    @Override
    public boolean addRegistration(Registration registration) {
        registrations.add(registration);
        return true;
    }
}
