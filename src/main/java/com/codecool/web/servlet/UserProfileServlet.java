package com.codecool.web.servlet;

import com.codecool.web.model.*;
import com.codecool.web.service.UserProfileService;

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
        UserProfileService service = new UserProfileService();

        req.setAttribute("role", service.getRole());
        req.setAttribute("userProfile", service.getReg());

        req.getRequestDispatcher("/profile.jsp").forward(req, resp);
    }
}
