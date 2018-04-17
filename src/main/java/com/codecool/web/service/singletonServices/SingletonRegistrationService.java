package com.codecool.web.service.singletonServices;

import com.codecool.web.model.Registration;
import com.codecool.web.dao.singletonDB.SingletonDataBase;

import java.util.List;

public final class SingletonRegistrationService {

    public Registration getReg(String name, String email, String password, String firstName, String lastName) {

        return new Registration(name, email, password, firstName, lastName);
    }

//    public Registration getProfile(int id) {
    public Registration getProfile(String id) {
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
