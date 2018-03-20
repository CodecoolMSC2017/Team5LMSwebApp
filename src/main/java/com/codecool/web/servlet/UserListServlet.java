package com.codecool.web.servlet;


import com.codecool.web.model.Registration;
import com.codecool.web.model.SingletonDataBase;
import com.codecool.web.service.RegistrationService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {

    private final RegistrationService service = new RegistrationService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("userlist", SingletonDataBase.getInstance().getAllRegistration());
        req.getRequestDispatcher("/userlist.jsp").forward(req, resp);
    }
}
