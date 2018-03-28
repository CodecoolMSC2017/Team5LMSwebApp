package com.codecool.web.servlet;

import com.codecool.web.model.*;
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
        Mentor mentor;
        Student student;
        Registration registration = SingletonDataBase.getInstance().getLogin().getReg();
        if (registration instanceof Mentor){
            mentor = (Mentor) registration;
            req.setAttribute("role", "Mentor");
            req.setAttribute("userProfile", mentor);
        } else {
            student = (Student) registration;
            req.setAttribute("role", "Student");
            req.setAttribute("userProfile", student);
        }

        req.getRequestDispatcher("/profile.jsp").include(req, resp);
        req.getRequestDispatcher("/importUserProfile.jsp").include(req, resp);
        req.getRequestDispatcher("/header.js").include(req, resp);


    }
}
