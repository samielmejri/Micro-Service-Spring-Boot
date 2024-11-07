package tn.lastdance.quizz.Interfaces;

import tn.lastdance.quizz.Entities.Question;

import java.util.List;

public interface IQuestionService {
    public List<Question> findAll();
    public Question findById(long id);
    public Question add(Question question);
    public Question update(Question question);
    public String delete(long id);

}
