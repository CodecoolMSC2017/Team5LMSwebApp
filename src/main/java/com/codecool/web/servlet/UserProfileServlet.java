package com.codecool.web.servlet;

import com.codecool.web.model.SingletonDataBase;
import com.codecool.web.service.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userProfileServlet")
public class UserProfileServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        int id = Integer.parseInt(req.getParameter("id"));
        String id = req.getParameter("id");
        RegistrationService service = new RegistrationService();

        if (id.equals("")) req.setAttribute("profile", SingletonDataBase.getInstance().getLogin().getReg());
        else req.setAttribute("profile", service.getProfile(id));

        req.setAttribute("userProfile", SingletonDataBase.getInstance().getLogin().getReg());

        req.getRequestDispatcher("/profile.jsp").forward(req, resp);
    }
}
