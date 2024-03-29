package com.codecool.web.servlet;

import com.codecool.web.model.Registration;
import com.codecool.web.service.singletonServices.SingletonQuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/protected/QuestionCreateServlet")
public class QuestionCreateServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        int id = Integer.parseInt(req.getParameter("id"));
        SingletonQuizService service = new SingletonQuizService();
        service.addQuestion(service.getQuiz(id));

        req.setAttribute("quiz", service.getQuiz(id));

        req.getRequestDispatcher("edit_quiz.jsp").include(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        doGet(req, resp);
    }
}
