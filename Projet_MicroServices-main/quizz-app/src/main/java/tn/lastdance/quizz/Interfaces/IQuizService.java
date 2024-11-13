package tn.lastdance.quizz.Interfaces;

import tn.lastdance.quizz.Entities.Quiz;

import java.util.List;

public interface IQuizService {
    public Quiz add(Quiz quiz);

    public Quiz findById(long id);

    public List<Quiz> findAll();

    public Quiz update(Quiz quiz);

    public String delete(long id);


}
