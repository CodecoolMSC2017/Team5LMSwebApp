package com.codecool.web.service.databaseServices;

import com.codecool.web.dao.Storing;
import com.codecool.web.model.Assignment;
import com.codecool.web.service.AssignmentService;

public class DatabaseAssignmentService extends AbstractDatabaseService implements AssignmentService {

    public DatabaseAssignmentService(Storing db) {
        super(db);
    }

    @Override
    public Assignment getAssignment(int id) {
        return null;
    }

    @Override
    public void update(Assignment ass, String title, String time, String shortDesc, String fullDisc) {

    }

    @Override
    public void delAssignment(int id) {

    }
}
