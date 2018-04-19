package com.codecool.web.service;

import com.codecool.web.model.Assignment;

import java.sql.SQLException;

public interface AssignmentService {

    Assignment getAssignment(int id) throws SQLException;
    void update(Assignment ass, String title, String time, String shortDesc, String fullDisc);
    void delAssignment(int id);
}
