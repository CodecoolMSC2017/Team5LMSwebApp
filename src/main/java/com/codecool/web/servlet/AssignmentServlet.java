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

        req.setAttribute("assignlist", SingletonDataBase.getInstance().getAssignmentList());
        req.getRequestDispatcher("/curicullum.jsp").forward(req, resp);


    }
}
