package com.codecool.web.service.databaseServices;

import com.codecool.web.dao.Storing;

public abstract class AbstractDatabaseService {

    final Storing db;

    public AbstractDatabaseService(Storing db) {
        this.db = db;
    }
}
