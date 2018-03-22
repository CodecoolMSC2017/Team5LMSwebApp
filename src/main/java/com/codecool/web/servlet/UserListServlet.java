package com.codecool.web.servlet;

import com.codecool.web.model.Login;
import com.codecool.web.model.SingletonDataBase;
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

        Login user = SingletonDataBase.getInstance().getLogin();

        req.setAttribute("userProfile", user);
        req.setAttribute("userlist", SingletonDataBase.getInstance().getAllRegistration());
        req.getRequestDispatcher("/userlist.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        doGet(req, resp);
    }
}
