package com.codecool.web.model;

import java.util.ArrayList;
import java.util.List;

public class SingletonDataBase {

    private static final SingletonDataBase Instance = new SingletonDataBase();
    private static List<Registration> registrations = new ArrayList<>();

    public static SingletonDataBase getInstance()
    {
        return Instance;
    }

    private SingletonDataBase() {
    }

    public static List<Registration> getRegistrations() {
        return registrations;
    }
}
