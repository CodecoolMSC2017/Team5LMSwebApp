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

    public void update(Quiz quiz, String title, String date, String description){
        quiz.setTitle(title);
        quiz.setDate(date);
        quiz.setDescription(description);
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

    public Question getQuestion(Quiz quiz, int id){
        for (Question q:quiz.getQuestions()){
            if (q.getId() == id){
                return q;
            }
        }return null;
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

    public void updateQuestion(Question q, int point, String description, String goodAnswer){
        q.setPoint(point);
        q.setDescription(description);
        q.setGoodAnswer(goodAnswer);
    }

    public void addAnswer(Question question){
        question.getAnswers().add(new Answer("New Answer"));
    }

    public Answer getAnswer(Quiz quiz, int id){
        for (Question q:quiz.getQuestions()) {
            for (Answer a : q.getAnswers()) {
                if (a.getId() == id) {
                    return a;
                }
            }
        }
        return null;
    }

    public void delAnswer(int id){
        for(AandQStore aq:SingletonDataBase.getInstance().getaQStores()){
            List<Quiz> quizzes = aq.getQuizzes();
            for(Quiz q:quizzes){
                List<Question> questions = q.getQuestions();
                for (Question que:questions){
                    List<Answer> answers = que.getAnswers();
                    for(int i = 0; answers.size()>i;i++){
                        if(answers.get(i).getId() == id){
                            answers.remove(i);
                        }
                    }
                }
            }
        }
    }
}
