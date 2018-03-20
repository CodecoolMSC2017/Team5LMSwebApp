package com.codecool.web.model;

import java.util.List;

public class RegistrationStoring implements Storing{

    @Override
    public List<Registration> getAllRegistration() {
        return SingletonDataBase.getInstance().getRegistrations();
    }

    @Override
    public Registration getRegistration() {
        return null;
    }

    @Override
    public void updateReg(Registration registration) {

    }

    @Override
    public void deleteReg(Registration registration) {

    }
}
