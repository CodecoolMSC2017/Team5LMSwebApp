package com.codecool.web.service.databaseServices;


import com.codecool.web.dao.Storing;

import com.codecool.web.model.Registration;
import com.codecool.web.service.LoginService;

import java.sql.SQLException;
import java.util.List;

public class DatabaseLoginService extends AbstractDatabaseService implements LoginService{

    public DatabaseLoginService(Storing db) {
        super(db);
    }

    @Override
    public boolean login(String nameOrEmail, String password) throws SQLException{

        List<Registration> registrations = db.getAllRegistration();

        for (Registration registeredUser : registrations) {
            if (((registeredUser.getName().equals(nameOrEmail)||registeredUser.getEmail().equals(nameOrEmail)) && registeredUser.getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }
}
