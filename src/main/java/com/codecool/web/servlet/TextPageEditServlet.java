package com.codecool.web.servlet;

import com.codecool.web.model.Registration;
import com.codecool.web.service.AssignmentService;
import com.codecool.web.service.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/protected/TextPageEditServlet")
public class TextPageEditServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        AssignmentService service = new AssignmentService();
        req.setAttribute("assignment", service.getAssignment(id));

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        req.getRequestDispatcher("edit_textpage.jsp").include(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        doGet(req, resp);
    }
}
