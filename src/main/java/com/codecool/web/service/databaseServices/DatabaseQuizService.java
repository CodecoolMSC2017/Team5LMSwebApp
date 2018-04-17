package com.codecool.web.service.databaseServices;

import com.codecool.web.model.Answer;
import com.codecool.web.model.Question;
import com.codecool.web.model.Quiz;
import com.codecool.web.service.QuizService;

public class DatabaseQuizService implements QuizService {

    @Override
    public Quiz getQuiz(int id) {
        return null;
    }

    @Override
    public void update(Quiz quiz, String title, String date, String description) {

    }

    @Override
    public void delQuiz(int id) {

    }

    @Override
    public void addQuestion(Quiz quiz) {

    }

    @Override
    public Question getQuestion(Quiz quiz, int id) {
        return null;
    }

    @Override
    public void delQuestion(int id) {

    }

    @Override
    public void updateQuestion(Question q, int point, String description, String goodAnswer) {

    }

    @Override
    public void addAnswer(Question question) {

    }

    @Override
    public Answer getAnswer(Quiz quiz, int id) {
        return null;
    }

    @Override
    public void delAnswer(int id) {

    }
}
