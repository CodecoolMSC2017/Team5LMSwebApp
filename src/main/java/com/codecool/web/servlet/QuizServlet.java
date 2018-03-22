package com.codecool.web.servlet;

import com.codecool.web.model.SingletonDataBase;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String answer1 = req.getParameter("answer1");
        String ans = "Good answer";
        req.setAttribute("answer1", ans);
        req.getRequestDispatcher("/quizAnswer.jsp").forward(req, resp);
    }
}
