package com.codecool.web.servlet;

import com.codecool.web.dao.Storing;
import com.codecool.web.dao.database.DaoDB;
import com.codecool.web.model.Registration;
import com.codecool.web.service.AssignmentService;
import com.codecool.web.service.databaseServices.DatabaseAssignmentService;
import com.codecool.web.service.singletonServices.SingletonAssignmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/Assignement")
public class AssignmentServlet extends AbstractServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Storing db = new DaoDB(connection);

            int id = Integer.parseInt(req.getParameter("id"));
            AssignmentService service = new DatabaseAssignmentService(db);
            req.setAttribute("assignment", service.getAssignment(id));

            Registration reg = (Registration) req.getSession().getAttribute("user");
            req.setAttribute("userProfile", reg);

            req.getRequestDispatcher("assignpage.jsp").include(req, resp);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        doGet(req, resp);
    }
}
