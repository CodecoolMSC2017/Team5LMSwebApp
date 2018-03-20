package com.codecool.web.model;

import java.util.List;

public interface Storing {

    public List<Registration> getAllRegistration();
    public void addRegistration(Registration registration);
    public Registration getRegistration(String name);
    public void updateReg(Registration registration);
    public void deleteReg(Registration registration);
}
