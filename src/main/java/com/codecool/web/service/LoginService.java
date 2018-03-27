package com.codecool.web.service;

import com.codecool.web.model.Login;
import com.codecool.web.model.Registration;
import com.codecool.web.model.SingletonDataBase;
import java.util.List;

public final class LoginService {

    public Login getLogin(String nameOrEmail, String password) {

        String message = null;

        List<Registration> registrations = SingletonDataBase.getInstance().getAllRegistration();

        if ( registrations.size() == 0 ) message = "No one registered yet!";
        else {
            for (Registration registeredUser : registrations) {
                if ( ((registeredUser.getName().equals(nameOrEmail)||registeredUser.getEmail().equals(nameOrEmail)) && registeredUser.getPassword().equals(password) )
                    ) {
                    message = "Logged in.";
                    return new Login(registeredUser, message);
                } else {
                    message = "Wrong name or password!";
                }
            }
        }
        return new Login(message);
    }
}
