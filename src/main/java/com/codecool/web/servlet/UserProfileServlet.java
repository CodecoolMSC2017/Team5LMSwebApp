package com.codecool.web.servlet;

import com.codecool.web.model.Registration;
import com.codecool.web.model.SingletonDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserProfileServlet {


    @WebServlet("/userProfileServlet")
    public class RegistrationServlet extends HttpServlet {

        private Registration regUserProfile;

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            SingletonDataBase.getInstance().updateReg(regUserProfile);
            req.setAttribute("userProfile", regUserProfile);
            req.getRequestDispatcher("/userProfile.jsp").include(req, resp);
        }
    }
}