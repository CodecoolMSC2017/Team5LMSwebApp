package com.codecool.web.service;

import com.codecool.web.model.AandQStore;
import com.codecool.web.model.Quiz;
import com.codecool.web.model.SingletonDataBase;

import java.util.List;

public class QuizService {


    public Quiz getQuiz(int id) {
        Quiz quiz;
        List<AandQStore> aQstores = SingletonDataBase.getInstance().getaQStores();

        for (AandQStore aq : aQstores) {
            List<Quiz> quizzes = aq.getQuizzes();
            for (Quiz q : quizzes) {
                if (id == q.getId()) {
                    quiz = q;
                    return quiz;
                }
            }
        }
        return null;
    }
}
