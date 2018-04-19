package com.codecool.web.service;

import com.codecool.web.model.Answer;
import com.codecool.web.model.Question;
import com.codecool.web.model.Quiz;

import java.sql.SQLException;

public interface QuizService {

    Quiz getQuiz(int id) throws SQLException;
    void update(Quiz quiz, String title, String date, String description);
    void delQuiz(int id);
    void addQuestion(Quiz quiz);
    Question getQuestion(Quiz quiz, int id);
    void delQuestion(int id);
    void updateQuestion(Question q, int point, String description, String goodAnswer);
    void addAnswer(Question question);
    Answer getAnswer(Quiz quiz, int id);
    void delAnswer(int id);
}
