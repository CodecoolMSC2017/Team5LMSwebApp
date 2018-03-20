package com.codecool.web.servlet;

import com.codecool.web.model.Login;
import com.codecool.web.model.Registration;
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

        Login user = service.getLogin( req.getParameter("name"), req.getParameter("email"), req.getParameter("password") );
        req.setAttribute("login", user);

        List<Registration> registrations = SingletonDataBase.getInstance().getAllRegistration();
        List<String> names = SingletonDataBase.getInstance().getNames();

        for (Registration reg:registrations) {
            if (names.contains( reg.getName().equals("name")) ) {
                req.getRequestDispatcher("/main.jsp").include(req, resp);
            }
            else req.getRequestDispatcher("/lofin_failed.jsp").include(req, resp);
        }
        
    }
}
