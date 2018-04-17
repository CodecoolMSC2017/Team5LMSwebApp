package com.codecool.web.service.singletonServices;

import com.codecool.web.model.Registration;
import com.codecool.web.dao.singletonDB.SingletonDataBase;
import com.codecool.web.service.LoginService;

import java.util.List;

public final class SingletonLoginService implements LoginService{

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
