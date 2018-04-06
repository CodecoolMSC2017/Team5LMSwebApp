package com.codecool.web.servlet;

import com.codecool.web.model.AandQStore;
import com.codecool.web.model.Registration;
import com.codecool.web.service.AandQService;
import com.codecool.web.service.AssignmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/protected/AandQStoreEditServlet")
public class AandQStoreEditServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        AandQService service = new AandQService();
        req.setAttribute("AandQStore", service.getAandQStore(id));

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        req.getRequestDispatcher("edit_assignments.jsp").include(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        doGet(req, resp);
    }
}
