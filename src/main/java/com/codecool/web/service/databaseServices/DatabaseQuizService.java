package com.codecool.web.service.databaseServices;

import com.codecool.web.dao.Storing;
import com.codecool.web.dao.singletonDB.SingletonDataBase;
import com.codecool.web.model.AandQStore;
import com.codecool.web.model.Answer;
import com.codecool.web.model.Question;
import com.codecool.web.model.Quiz;
import com.codecool.web.service.QuizService;

import java.sql.SQLException;
import java.util.List;

public class DatabaseQuizService extends AbstractDatabaseService implements QuizService {

    public DatabaseQuizService(Storing db) {
        super(db);
    }

    @Override
    public Quiz getQuiz(int id) throws SQLException {
        Quiz quiz;
        List<AandQStore> aQstores = db.getaQStores();

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
