package com.codecool.web.servlet;

import com.codecool.web.model.Assignment;
import com.codecool.web.model.Registration;
import com.codecool.web.model.SingletonDataBase;
import com.codecool.web.service.AssignmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/protected/TextPageSaveServlet")
public class TextPageSaveServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        AssignmentService service = new AssignmentService();
        Assignment ass = service.getAssignment(id);

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String estimatedtime = req.getParameter("estimatedtime");
        String fulldescription = req.getParameter("fulldescription");

        service.update(ass, title, estimatedtime, description, fulldescription);

        req.setAttribute("profile", req.getSession().getAttribute("user"));
        req.setAttribute("userProfile", req.getSession().getAttribute("user"));


        req.getRequestDispatcher("AandQStoreServlet").forward(req, resp);
    }
}
