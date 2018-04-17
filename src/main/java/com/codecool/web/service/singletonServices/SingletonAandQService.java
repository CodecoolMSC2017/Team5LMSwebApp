package com.codecool.web.service.singletonServices;

import com.codecool.web.model.AandQStore;
import com.codecool.web.dao.singletonDB.SingletonDataBase;
import com.codecool.web.service.AandQService;

public class SingletonAandQService implements AandQService{

    public AandQStore getAandQStore(int id){

        for(AandQStore aq:SingletonDataBase.getInstance().getaQStores()){
            if(aq.getId() == id){
                return aq;
            }
        }
        return null;
    }
}
