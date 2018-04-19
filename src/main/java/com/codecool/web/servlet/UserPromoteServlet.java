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

@WebServlet("/protected/UserPromoteServlet")
public class UserPromoteServlet extends AbstractServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try (Connection connection = getConnection(req.getServletContext())) {
            Storing db = new DaoDB(connection);

            String name = req.getParameter("id");
            for (Registration reg : db.getAllRegistration()) {
                if (name.equals(reg.getName())) {
                    db.userPromote(name,"Mentor");
                }
            }
            resp.sendRedirect("userListServlet");

        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
