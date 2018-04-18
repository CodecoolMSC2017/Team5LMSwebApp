package com.codecool.web.servlet;

import com.codecool.web.dao.Storing;
import com.codecool.web.dao.database.DaoDB;
import com.codecool.web.model.Registration;
import com.codecool.web.service.RegistrationService;
import com.codecool.web.service.databaseServices.DatabaseRegistrationService;
import com.codecool.web.service.singletonServices.SingletonRegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/userProfileServlet")
public class UserProfileServlet extends AbstractServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {
            Storing db = new DaoDB(connection);
            String id = req.getParameter("id");
            RegistrationService service = new DatabaseRegistrationService(db);

            if (id.equals(""))
                 req.setAttribute("profile", req.getSession().getAttribute("user"));
            else
                   req.setAttribute("profile", service.getProfile(id));

            Registration reg = (Registration) req.getSession().getAttribute("user");
            req.setAttribute("userProfile", reg);
            req.getRequestDispatcher("profile.jsp").forward(req, resp);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
