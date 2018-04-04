package com.codecool.web.servlet;

import com.codecool.web.model.*;
import com.codecool.web.service.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/protected/quizSubmit")
public class EvaluationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] answer = req.getParameterValues("answers.getName()");

        req.setAttribute("answer", answer);

        req.getRequestDispatcher("quizResult.jsp").include(req, resp);
    }


}
