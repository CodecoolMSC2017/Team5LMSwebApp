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

    public void update(Assignment ass, String title, String time, String shortDesc, String fullDisc){
        ass.setTitle(title);
        ass.setTime(Integer.parseInt(time));
        ass.setDescription(shortDesc);
        ass.setFullDescription(fullDisc);
    }

    public void delAssignment(int id){

        List<AandQStore> aQstores = SingletonDataBase.getInstance().getaQStores();

        for(AandQStore aq:aQstores){
            List<Assignment> assigns = aq.getAssignments();
            for(int i=0; assigns.size() > i;i++){
                if(id == assigns.get(i).getId()){
                    assigns.remove(i);
                }
            }
        }
    }
}
