package com.codecool.web.servlet;

import com.codecool.web.model.Registration;
import com.codecool.web.dao.singletonDB.SingletonDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/protected/userProfileSaveServlet")
public class UserProfileSaveServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        int id = Integer.parseInt(req.getParameter("id"));
        String id = req.getParameter("id");
        for ( Registration reg : SingletonDataBase.getInstance().getAllRegistration() ) {
            if ( id.equals(reg.getName()) ) {
                String fname = req.getParameter("first_name");
                String lname = req.getParameter("last_name");
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                Registration registration = SingletonDataBase.getInstance().updateReg(reg, fname, lname, email, password);

                req.setAttribute("profile", req.getSession().getAttribute("user"));
                req.setAttribute("userProfile", req.getSession().getAttribute("user"));
            }
        }
        Registration reg = (Registration) req.getSession().getAttribute("user");
        if ( id.equals(reg.getName()) ) {
            req.getRequestDispatcher("profile.jsp").forward(req, resp);
        }
        else req.getRequestDispatcher("userListServlet").forward(req, resp);

    }
}
