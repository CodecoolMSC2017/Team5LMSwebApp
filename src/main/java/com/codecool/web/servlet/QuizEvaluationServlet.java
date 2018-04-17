package com.codecool.web.servlet;

import com.codecool.web.service.singletonServices.SingletonQuizService;
import com.codecool.web.model.Quiz;
import com.codecool.web.model.Question;
import com.codecool.web.model.Registration;
import com.codecool.web.service.singletonServices.SingletonRegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/protected/quizSubmit")
public class QuizEvaluationServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        SingletonQuizService service = new SingletonQuizService();
        Quiz quiz = service.getQuiz(id);

        String chosenAnswer = "";
        List<String> chosenAnswers = new ArrayList<>();
        List<String> godAnswerList = new ArrayList<>();
        int points = 0;

        for (int i = 0; i < quiz.getQuestions().size(); i++) {
            Question question = quiz.getQuestions().get(i);
            String godanswer = quiz.getQuestions().get(i).getGoodAnswer();
            chosenAnswer = req.getParameter("question" + i);
            chosenAnswers.add(chosenAnswer);


            if(chosenAnswer.equals(godanswer)) {
                points += quiz.getQuestions().get(i).getPoint();
            }
        }

        SingletonRegistrationService registrationService =  new SingletonRegistrationService();

        req.setAttribute("quiz", service.getQuiz(id));
        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        reg.getQuizResult().put(id, points);

        req.setAttribute("quiz", service.getQuiz(id));


        req.setAttribute("points", points);



        req.getRequestDispatcher("quiz.jsp").forward(req, resp);
    }


}
