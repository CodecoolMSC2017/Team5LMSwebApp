package com.codecool.web.service;

import com.codecool.web.model.Assignment;

public interface AssignmentService {

    Assignment getAssignment(int id);
    void update(Assignment ass, String title, String time, String shortDesc, String fullDisc);
    void delAssignment(int id);
}
