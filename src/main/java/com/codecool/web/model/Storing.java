package com.codecool.web.model;

import java.util.List;

public interface Storing {

    public List<Registration> getAllRegistration();
    public Registration getRegistration();
    public void updateReg(Registration registration);
    public void deleteReg(Registration registration);
}
