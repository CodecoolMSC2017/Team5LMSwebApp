package com.codecool.web.servlet;

import com.codecool.web.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("userProfile", SingletonDataBase.getInstance().getLogin().getReg());
        req.setAttribute("mentorlist", SingletonDataBase.getInstance().getMentors());
        req.setAttribute("studentlist", SingletonDataBase.getInstance().getStudents());

        req.getRequestDispatcher("/users.jsp").forward(req, resp);
        req.getRequestDispatcher("/importUserProfile.jsp").include(req, resp);
        req.getRequestDispatcher("/header.js").include(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        doGet(req, resp);
    }
}
