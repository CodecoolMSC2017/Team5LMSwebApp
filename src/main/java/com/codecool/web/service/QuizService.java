package com.codecool.web.service;

import com.codecool.web.model.*;

import java.util.ArrayList;
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

    public void delQuiz(int id){

        List<AandQStore> aQstores = SingletonDataBase.getInstance().getaQStores();

        for(AandQStore aq:aQstores){
            List<Quiz> quizzes = aq.getQuizzes();
            for(int i=0; quizzes.size() > i;i++){
                if(id == quizzes.get(i).getId()){
                    quizzes.remove(i);
                }
            }
        }
    }

    public void addQuestion(Quiz quiz){
        quiz.getQuestions().add(new Question("New Question", 0, new ArrayList<>(), "good answer"));
    }

    public void delQuestion(int id){

        for(AandQStore aq:SingletonDataBase.getInstance().getaQStores()){
            List<Quiz> quizzes = aq.getQuizzes();
            for(Quiz q:quizzes){
                List<Question> questions = q.getQuestions();
                for (int i = 0; questions.size() > i; i++)
                if(id == questions.get(i).getId()){
                    questions.remove(i);
                }
            }
        }
    }
}
