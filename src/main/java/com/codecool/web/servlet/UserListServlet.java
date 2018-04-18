package com.codecool.web.servlet;

import com.codecool.web.dao.Storing;
import com.codecool.web.dao.database.DaoDB;
import com.codecool.web.dao.singletonDB.SingletonDataBase;
import com.codecool.web.model.*;
import com.codecool.web.service.LoginService;
import com.codecool.web.service.databaseServices.DatabaseLoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet("/protected/userListServlet")
public class UserListServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Storing db = new DaoDB(connection);

            Registration reg = (Registration) req.getSession().getAttribute("user");
            req.setAttribute("userProfile", reg);

            req.setAttribute("mentorlist", db.getMentors());
            req.setAttribute("studentlist", db.getStudents());

            req.getRequestDispatcher("users.jsp").include(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        doGet(req, resp);
    }
}
