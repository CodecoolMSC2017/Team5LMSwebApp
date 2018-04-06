package com.codecool.web.service;

import com.codecool.web.model.AandQStore;
import com.codecool.web.model.SingletonDataBase;

public class AandQService {

    public AandQStore getAandQStore(int id){

        for(AandQStore aq:SingletonDataBase.getInstance().getaQStores()){
            if(aq.getId() == id){
                return aq;
            }
        }
        return null;
    }
}
