package com.codecool.web.service;

import com.codecool.web.model.Registration;
import com.codecool.web.model.SingletonDataBase;

import java.util.List;

public final class RegistrationService {

    public Registration getReg(String name, String email, String password, String firstName, String lastName) {

        return new Registration(name, email, password, firstName, lastName);
    }

//    public Registration getProfile(int id) {
    public Registration getProfile(String id) {
        if (id.equals(null)) {
            return SingletonDataBase.getInstance().getLogin().getReg();
        }
        else {
            Registration reg;
            List<Registration> registrations = SingletonDataBase.getInstance().getAllRegistration();
            for (Registration r : registrations) {
                if (id.equals(r.getName())) {
                    reg = r;
                    return reg;
                }
            }
            return null;
        }
    }

}
