package com.codecool.web.servlet;


import com.codecool.web.model.Registration;
import com.codecool.web.service.singletonServices.SingletonQuizService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/protected/AnswerDelServlet")
public class AnswerDelServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        String id = req.getParameter("id");
        int quizId = Integer.parseInt(id.substring(0,4));
        int answerId = Integer.parseInt(id.substring(4,9));
        SingletonQuizService service = new SingletonQuizService();
        service.delAnswer(answerId);

        req.setAttribute("quiz", service.getQuiz(quizId));

        req.getRequestDispatcher("edit_quiz.jsp").include(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        doGet(req, resp);
    }
}
