package com.codecool.web.servlet;


import com.codecool.web.model.Answer;
import com.codecool.web.model.Question;
import com.codecool.web.model.Quiz;
import com.codecool.web.model.Registration;
import com.codecool.web.service.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/protected/QuizSaveServlet")
public class QuizSaveServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Quiz parameters
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String date = req.getParameter("date");
        //Question(s) parameters
        String[] questiondIDs = req.getParameterValues("QuId");
        String[] questionsPoints = req.getParameterValues("points");
        String[] questionsDescripton = req.getParameterValues("question_description");
        //Answer(s) parameters
        String[] answerIDs = req.getParameterValues("answer_id");
        String[] answerNames = req.getParameterValues("answer_name");
        String[] questionsGoodAnswer = req.getParameterValues("good_answer");

        QuizService service = new QuizService();

        //Quiz update
        Quiz quiz = service.getQuiz(id);
        service.update(quiz, title, date, description);

        //Question(s) update
        for(int i=0; questiondIDs.length > i; i++){
            Question q = service.getQuestion(quiz, Integer.parseInt(questiondIDs[i]));
            service.updateQuestion(q, Integer.parseInt(questionsPoints[i]), questionsDescripton[i], questionsGoodAnswer[i]);
        }
        //Answer(s) update
        for(int i=0; answerIDs.length > i;i++) {
            Answer a = service.getAnswer(quiz, Integer.parseInt(answerIDs[i]));
            a.setName(answerNames[i]);
        }

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        req.getRequestDispatcher("QuizEditServlet").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }
}
