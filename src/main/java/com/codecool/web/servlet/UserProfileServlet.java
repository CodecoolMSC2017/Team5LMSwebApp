package com.codecool.web.servlet;

import com.codecool.web.model.Registration;
import com.codecool.web.service.singletonServices.SingletonRegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/protected/userProfileServlet")
public class UserProfileServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        int id = Integer.parseInt(req.getParameter("id"));
        String id = req.getParameter("id");
        SingletonRegistrationService service = new SingletonRegistrationService();

        if (id.equals("")) req.setAttribute("profile", req.getSession().getAttribute("user"));
        else req.setAttribute("profile", service.getProfile(id));

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }
}
