package com.codecool.web.service.databaseServices;

import com.codecool.web.dao.Storing;
import com.codecool.web.model.Registration;
import com.codecool.web.service.RegistrationService;

import java.sql.SQLException;
import java.util.List;

public class DatabaseRegistrationService extends AbstractDatabaseService implements RegistrationService {

    public DatabaseRegistrationService(Storing db) {
        super(db);
    }

    @Override
    public Registration getReg(String name, String email, String password, String firstName, String lastName) {
        return null;
    }

    @Override
    public Registration getProfile(String id) throws SQLException {

        Registration reg;
        List<Registration> registrations = db.getAllRegistration();
        for (Registration r : registrations) {
            if (id.equals(r.getName())) {
                reg = r;
                return reg;
            }
        }
        return null;
    }
}
