package com.codecool.web.servlet;

import com.codecool.web.model.Registration;
import com.codecool.web.dao.singletonDB.SingletonDataBase;
import com.codecool.web.service.singletonServices.SingletonRegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;;
import java.io.IOException;


@WebServlet("/registrationServlet")
public class RegistrationServlet extends HttpServlet {

    private final SingletonRegistrationService service = new SingletonRegistrationService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Registration newUser;
            newUser = service.getReg(req.getParameter("name"), req.getParameter("email"), req.getParameter("password"), req.getParameter("first_name"), req.getParameter("last_name"));

        if (SingletonDataBase.getInstance().addRegistration(newUser)) {
            req.setAttribute("message", "Registration succesfull");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "This name or email already registered");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        doPost(req, resp);
    }*/
}
