package com.codecool.web.service;

import com.codecool.web.model.Registration;
import com.codecool.web.model.SingletonDataBase;
import java.util.List;

public final class LoginService {

    public boolean login(String nameOrEmail, String password) {

        List<Registration> registrations = SingletonDataBase.getInstance().getAllRegistration();

        for (Registration registeredUser : registrations) {
            if (((registeredUser.getName().equals(nameOrEmail)||registeredUser.getEmail().equals(nameOrEmail)) && registeredUser.getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }
}
