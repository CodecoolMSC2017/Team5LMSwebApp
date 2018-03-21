package com.codecool.web.servlet;

import com.codecool.web.model.Registration;
import com.codecool.web.model.SingletonDataBase;
import com.codecool.web.service.RegistrationService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;;
import java.io.IOException;


@WebServlet("/registrationServlet")
public class RegistrationServlet extends HttpServlet {

    private final RegistrationService service = new RegistrationService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Registration newUser = service.getRegistration(req.getParameter("name"), req.getParameter("email"), req.getParameter("password"), req.getParameter("password_confirm"), req.getParameter("role"));
        req.setAttribute("registration", newUser);

        if ( newUser.getMessage().equals("Your registration was successful.") && SingletonDataBase.getInstance().addRegistration(newUser) == true ) {
            req.getRequestDispatcher("/registration_success.jsp").include(req, resp);
        }
        else req.getRequestDispatcher("/registration_failed.jsp").include(req, resp);
    }
}
