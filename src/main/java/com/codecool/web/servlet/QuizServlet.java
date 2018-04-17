package com.codecool.web.servlet;

import com.codecool.web.model.*;
import com.codecool.web.service.singletonServices.SingletonQuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/protected/Quiz")
public class QuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        SingletonQuizService service = new SingletonQuizService();
        req.setAttribute("quiz", service.getQuiz(id));
        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);
        if(reg.getQuizResult().containsKey(id)) {
            Integer points = reg.getQuizResult().get(id);
            req.setAttribute("points", points);

        }



        //Integer points = reg.getPoints();
        final PrintWriter writerA = resp.getWriter();


        req.getRequestDispatcher("quiz.jsp").include(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        doGet(req, resp);
    }
}
