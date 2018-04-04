package com.codecool.web.servlet;

import com.codecool.web.model.Registration;
import com.codecool.web.model.SingletonDataBase;
import com.codecool.web.service.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/protected/UserPromoteServlet")
public class UserPromoteServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        int id = Integer.parseInt(req.getParameter("id"));
        String id = req.getParameter("id");
        for ( Registration reg : SingletonDataBase.getInstance().getAllRegistration() ) {
                if ( id.equals(reg.getName()) ) {
                    reg.setRole("Mentor");
                }
        }
        resp.sendRedirect("userListServlet");

    }
}
