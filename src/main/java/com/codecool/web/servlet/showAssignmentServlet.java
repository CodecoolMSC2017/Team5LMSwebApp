package com.codecool.web.servlet;


import com.codecool.web.model.Assignment;
import com.codecool.web.model.SingletonDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showAssignmentServlet")
public class showAssignmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String number = req.getParameter("number");
        Assignment assignment = SingletonDataBase.getInstance().getAssignment(number);

        req.setAttribute("assignment", assignment);
        req.getRequestDispatcher("/assignment_page.jsp").forward(req, resp);

    }
}
