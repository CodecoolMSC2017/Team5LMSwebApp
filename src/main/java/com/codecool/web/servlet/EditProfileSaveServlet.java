package com.codecool.web.servlet;

import com.codecool.web.model.Login;
import com.codecool.web.model.SingletonDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editProfileSaveServlet")
public class EditProfileSaveServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Login user = SingletonDataBase.getInstance().getLogin();
        String name = req.getParameter("name");
        String fname = req.getParameter("firstname");
        String lname = req.getParameter("lastname");
        String pass = req.getParameter("password");
        String conf_pass = req.getParameter("password_confirm");

        if (pass.equals(conf_pass)) {
            SingletonDataBase.getInstance().updateReg(user,name,fname, lname, pass, conf_pass);
            req.setAttribute("userProfile", user);
            req.getRequestDispatcher("/userProfile.jsp").include(req, resp);
        } else {
            req.setAttribute("userProfile", user);
            req.getRequestDispatcher("/update_failed.jsp").include(req, resp);
        }
    }
}
