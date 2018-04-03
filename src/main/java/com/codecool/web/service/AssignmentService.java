package com.codecool.web.service;

import com.codecool.web.model.AandQStore;
import com.codecool.web.model.Assignment;
import com.codecool.web.model.SingletonDataBase;

import java.util.List;

public class AssignmentService {

    public Assignment getAssignment(int id){

        Assignment assignment;
        List<AandQStore> aQstores = SingletonDataBase.getInstance().getaQStores();

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
}
