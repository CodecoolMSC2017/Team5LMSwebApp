package com.codecool.web.service;

import java.sql.SQLException;

public interface LoginService {

    boolean login(String nameOrEmail, String password) throws SQLException;

}
