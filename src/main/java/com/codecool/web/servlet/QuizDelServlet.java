package com.codecool.web.servlet;

import com.codecool.web.model.AandQStore;
import com.codecool.web.model.Assignment;
import com.codecool.web.model.Registration;
import com.codecool.web.model.SingletonDataBase;
import com.codecool.web.service.AandQService;
import com.codecool.web.service.AssignmentService;
import com.codecool.web.service.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/protected/QuizDelServlet")
public class QuizDelServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        int id = Integer.parseInt(req.getParameter("id"));
        QuizService service = new QuizService();
        service.delQuiz(id);

        if (reg.getRole().equals("Mentor")) {
            req.setAttribute("AandQlist", SingletonDataBase.getInstance().getaQStores());
        }else{
            req.setAttribute("AandQlist", SingletonDataBase.getInstance().getAQStoresPublished());
        }

        req.getRequestDispatcher("assignments.jsp").include(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        doGet(req, resp);
    }
}
