package com.codecool.web.servlet;

import com.codecool.web.model.Assignment;
import com.codecool.web.model.SingletonDataBase;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/curicullum")
public class AssignmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Assignment firstAssignment = new Assignment(1,"Learn Python", "Check Sololearn");
        SingletonDataBase.getInstance().addAssingmentList(firstAssignment);

        Assignment secondAssignment = new Assignment(2, "Learn Java", "Check Sololern/Java")
        SingletonDataBase.getInstance().addAssingmentList(secondAssignment);

        Assignment thirdAssignment = new Assignment(3, "Learn Html", "Check Sololern/html")
        SingletonDataBase.getInstance().addAssingmentList(thirdAssignment);

        Assignment fourthAssignment = new Assignment(4, "Learn Javascript", "Check Sololern/javascript")
        SingletonDataBase.getInstance().addAssingmentList(fourthAssignment);


        req.setAttribute("assignlist", SingletonDataBase.getInstance().getAssignmentList());
        req.getRequestDispatcher("/curicullum.jsp").forward(req, resp);


    }
}
