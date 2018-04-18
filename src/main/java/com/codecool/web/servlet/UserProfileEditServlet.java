package com.codecool.web.servlet;

import com.codecool.web.dao.Storing;
import com.codecool.web.dao.database.DaoDB;
import com.codecool.web.model.Registration;
import com.codecool.web.dao.singletonDB.SingletonDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/userProfileEdit")
public class UserProfileEditServlet extends AbstractServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {
            Storing db = new DaoDB(connection);
            String id = req.getParameter("id");
            for (Registration reg : db.getAllRegistration()) {
                if (id.equals(reg.getName())) {
                    req.setAttribute("profile", reg);

                    req.setAttribute("userProfile", req.getSession().getAttribute("user"));
                }
            }
            req.getRequestDispatcher("edit_profile.jsp").include(req, resp);
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
