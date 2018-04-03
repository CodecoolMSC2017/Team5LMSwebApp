package com.codecool.web.servlet;

import com.codecool.web.model.Registration;
import com.codecool.web.model.SingletonDataBase;
import com.codecool.web.service.LoginService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private final LoginService service = new LoginService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameOrEmail = req.getParameter("name_or_email");
        String password = req.getParameter("password");

        if(service.login(nameOrEmail, password)){

            Registration reg = SingletonDataBase.getInstance().getRegistration(nameOrEmail);
            req.getSession().setAttribute("user", reg);

            resp.sendRedirect("protected/AandQStoreServlet");

        } else {
            req.setAttribute("error", "Incorrect login parameters.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
