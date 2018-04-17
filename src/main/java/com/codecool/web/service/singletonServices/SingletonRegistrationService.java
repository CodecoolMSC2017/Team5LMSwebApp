package com.codecool.web.service.singletonServices;

import com.codecool.web.model.Registration;
import com.codecool.web.dao.singletonDB.SingletonDataBase;
import com.codecool.web.service.RegistrationService;

import java.util.List;

public final class SingletonRegistrationService implements RegistrationService {

    @Override
    public Registration getReg(String name, String email, String password, String firstName, String lastName) {

        return new Registration(name, email, password, firstName, lastName);
    }

    @Override
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
