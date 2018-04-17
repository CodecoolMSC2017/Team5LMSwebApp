package com.codecool.web.servlet;

import com.codecool.web.dao.Storing;
import com.codecool.web.dao.database.DaoDB;
import com.codecool.web.model.Registration;
import com.codecool.web.dao.singletonDB.SingletonDataBase;
import com.codecool.web.service.LoginService;
import com.codecool.web.service.databaseServices.DatabaseLoginService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet("/loginServlet")
public class LoginServlet extends AbstractServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

        try (Connection connection = getConnection(req.getServletContext())) {
            Storing db = new DaoDB(connection);
            LoginService service = new DatabaseLoginService(db);

            String nameOrEmail = req.getParameter("name_or_email");
            String password = req.getParameter("password");

            if(service.login(nameOrEmail, password)){

                Registration reg = db.getRegistration(nameOrEmail);
                req.getSession().setAttribute("user", reg);

                resp.sendRedirect("protected/HomeServlet");

            } else {
                req.setAttribute("error", "Incorrect login parameters.");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
