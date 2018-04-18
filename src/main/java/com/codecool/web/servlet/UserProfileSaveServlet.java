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
import java.util.List;

@WebServlet ("/protected/userProfileSaveServlet")
public class UserProfileSaveServlet extends AbstractServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {
            Storing db = new DaoDB(connection);
            List<Registration> regs = db.getAllRegistration();
            String id = req.getParameter("id");

            for (Registration reg : regs) {
                if (id.equals(reg.getName())) {
                    String fname = req.getParameter("first_name");
                    String lname = req.getParameter("last_name");
                    String email = req.getParameter("email");
                    String password = req.getParameter("password");
                    db.updateReg(reg, regs, fname, lname, email, password);
                }
            }

            Registration reg = (Registration) req.getSession().getAttribute("user");
            req.setAttribute("profile", reg);
            req.setAttribute("userProfile", reg);

            if (id.equals(reg.getName())) {
                req.getRequestDispatcher("profile.jsp").forward(req, resp);
            } else req.getRequestDispatcher("userListServlet").forward(req, resp);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
