package com.codecool.web.servlet;

import com.codecool.web.model.AandQStore;
import com.codecool.web.model.Assignment;
import com.codecool.web.model.Registration;
import com.codecool.web.model.SingletonDataBase;
import com.codecool.web.service.AandQService;
import com.codecool.web.service.AssignmentService;
import com.codecool.web.service.QuizService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/protected/QuestionDelServlet")
public class QuestionDelServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        String id =(req.getParameter("id"));
        int QuizId = Integer.parseInt(id.substring(0,4));
        int QuestionId = Integer.parseInt(id.substring(4,9));
        QuizService service = new QuizService();
        service.delQuestion(QuestionId);

        req.setAttribute("quiz", service.getQuiz(QuizId));

        req.getRequestDispatcher("edit_quiz.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        doGet(req, resp);
    }
}
