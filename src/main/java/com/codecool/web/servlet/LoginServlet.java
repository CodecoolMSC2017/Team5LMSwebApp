package com.codecool.web.servlet;

import com.codecool.web.model.Login;
import com.codecool.web.model.SingletonDataBase;
import com.codecool.web.service.LoginService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private final LoginService service = new LoginService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Login user = service.getLogin(req.getParameter("name_or_email"), req.getParameter("password"));
        req.setAttribute("login", user);

        if ( user.getMessage().equals("Logged in.") ) {
            req.getRequestDispatcher("AandQStoreServlet").include(req, resp);
            SingletonDataBase.getInstance().newLogin(user);
        }
        else req.getRequestDispatcher("/index.jsp").include(req, resp);

    }
}
