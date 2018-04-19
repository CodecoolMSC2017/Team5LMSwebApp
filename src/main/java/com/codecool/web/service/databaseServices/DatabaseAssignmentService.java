package com.codecool.web.service.databaseServices;

import com.codecool.web.dao.Storing;
import com.codecool.web.dao.database.DaoDB;
import com.codecool.web.dao.singletonDB.SingletonDataBase;
import com.codecool.web.model.AandQStore;
import com.codecool.web.model.Assignment;
import com.codecool.web.service.AssignmentService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DatabaseAssignmentService extends AbstractDatabaseService implements AssignmentService {

    public DatabaseAssignmentService(Storing db) {
        super(db);
    }

    @Override
    public Assignment getAssignment(int id) throws SQLException {
        Assignment assignment;
        List<AandQStore> aQstores = db.getaQStores();

        for(AandQStore aq:aQstores){
            List<Assignment> assigns = aq.getAssignments();
            for(Assignment assign:assigns){
                if(id == assign.getId()){
                    assignment = assign;
                    return assignment;
                }
            }
        }
        return null;
    }

    @Override
    public void update(Assignment ass, String title, String time, String shortDesc, String fullDisc) {

    }

    @Override
    public void delAssignment(int id) {

    }
}
