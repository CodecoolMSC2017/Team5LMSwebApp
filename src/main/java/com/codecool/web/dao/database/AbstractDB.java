package com.codecool.web.dao.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract class AbstractDB {

    final Connection connection;

    AbstractDB(Connection connection) {
        this.connection = connection;
    }

    void executeInsert(PreparedStatement statement) throws SQLException {
        int insertCount = statement.executeUpdate();
        if (insertCount != 1) {
            connection.rollback();
            throw new SQLException("");
        }
    }

    int fetchGeneratedId(PreparedStatement statement) throws SQLException {
        int id;
        try (ResultSet resultSet = statement.getGeneratedKeys()) {
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            } else {
                connection.rollback();
                throw new SQLException("");
            }
        }
        connection.commit();
        return id;
    }
}

