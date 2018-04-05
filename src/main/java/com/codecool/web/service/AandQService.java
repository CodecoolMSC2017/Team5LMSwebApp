package com.codecool.web.service;

import com.codecool.web.model.AandQStore;
import com.codecool.web.model.SingletonDataBase;
import java.util.List;

public class AandQService {

    public AandQStore getAandQStore(String name){

        for(AandQStore aq:SingletonDataBase.getInstance().getaQStores()){
            if(aq.getTitle().equals(name)){
                return aq;
            }
        }
        return null;
    }
}
