package com.codecool.web.service;

import com.codecool.web.model.Login;
import com.codecool.web.model.Registration;
import com.codecool.web.model.SingletonDataBase;
import java.util.List;

public final class LoginService {

    public Login getLogin(String nameOrEmail, String password) {

        String message = null;
        String name = null;
        String email = null;
        String role= null;
        List<Registration> registrations = SingletonDataBase.getInstance().getAllRegistration();
//        List<String> names = SingletonDataBase.getInstance().getNames();
//        List<String> emails = SingletonDataBase.getInstance().getEmails();

        if ( registrations.size() == 0 ) message = "No one registered yet!";
        else {
            for (Registration registeredUser : registrations) {
                if ( registeredUser.getName().equals(nameOrEmail) && registeredUser.getPassword().equals(password) ) {
                    name = nameOrEmail;
                    email = registeredUser.getEmail();
                    role = registeredUser.getRole();
                    message = "Logged in.";
                    break;
                }
                else if ( registeredUser.getEmail().equals(nameOrEmail) && registeredUser.getPassword().equals(password) ) {
                    name = registeredUser.getName();
                    email = nameOrEmail;
                    role = registeredUser.getRole();
                    message = "Logged in.";
                    break;
                }
                else {
                    message = "Wrong name or password!";
                }
            }
        }

        return new Login(name, email, password, role, message);
    }
}
