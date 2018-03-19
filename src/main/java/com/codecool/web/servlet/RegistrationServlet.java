package com.codecool.web.servlet;

import com.codecool.web.model.Registration;
import com.codecool.web.service.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registrationServlet")
public class RegistrationServlet extends HttpServlet {

    private final RegistrationService service = new RegistrationService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("registration",
            service.registration(req.getParameter("name"), req.getParameter("email"), req.getParameter("password"), req.getParameter("confirmPassword"), req.getParameter("role")));
        req.getRequestDispatcher("/registration_result.jsp").include(req, resp);
    }
}
