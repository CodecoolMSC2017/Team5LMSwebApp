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
            List<Registration> regs = db.getAllRegistration(); //Opt. search for reg with name in SQL
            String name = req.getParameter("id");
            String email = null;

            //get user we wish to update (with name), update it
            for (Registration reg : regs) {
                if (name.equals(reg.getName())) {
                    String fname = req.getParameter("first_name");
                    String lname = req.getParameter("last_name");
                    email = req.getParameter("email");
                    String password = req.getParameter("password");
                    db.updateReg(reg, regs, fname, lname, email, password);
                }
            }
            // get current session
            Registration chreg = (Registration) req.getSession().getAttribute("user");

            //if current session name = name we updated, then the session also updated
            if(chreg.getName().equals(name)){
                Registration reg = db.getRegistration(email); //Temporary Solution
                req.getSession().setAttribute("user", reg);
                req.setAttribute("profile", reg);
                req.setAttribute("userProfile", reg);
                req.getRequestDispatcher("profile.jsp").forward(req, resp);
            //else only attributes set
            }else{
                req.setAttribute("profile", chreg);
                req.setAttribute("userProfile", chreg);
                req.getRequestDispatcher("userListServlet").forward(req, resp);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
