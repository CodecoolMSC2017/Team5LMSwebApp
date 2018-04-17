package com.codecool.web.service.singletonServices;

import com.codecool.web.model.AandQStore;
import com.codecool.web.model.Assignment;
import com.codecool.web.dao.singletonDB.SingletonDataBase;
import com.codecool.web.service.AssignmentService;

import java.util.List;

public class SingletonAssignmentService implements AssignmentService {

    @Override
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

    @Override
    public void update(Assignment ass, String title, String time, String shortDesc, String fullDisc){
        ass.setTitle(title);
        ass.setTime(Integer.parseInt(time));
        ass.setDescription(shortDesc);
        ass.setFullDescription(fullDisc);
    }

    @Override
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
