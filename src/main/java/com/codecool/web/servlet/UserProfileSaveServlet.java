package com.codecool.web.servlet;

import com.codecool.web.model.Mentor;
import com.codecool.web.model.Registration;
import com.codecool.web.model.SingletonDataBase;
import com.codecool.web.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet ("/userProfileSaveServlet")
public class UserProfileSaveServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fname = req.getParameter("first_name");
        String lname = req.getParameter("last_name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        SingletonDataBase.getInstance().updateReg(fname, lname, email, password);

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
    }
}
