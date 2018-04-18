package com.codecool.web.service.databaseServices;

import com.codecool.web.dao.Storing;
import com.codecool.web.model.AandQStore;
import com.codecool.web.service.AandQService;

public class DatabaseAandQService extends AbstractDatabaseService implements AandQService {

    public DatabaseAandQService(Storing db) {
        super(db);
    }

    @Override
    public AandQStore getAandQStore(int id) {
        return null;
    }
}
