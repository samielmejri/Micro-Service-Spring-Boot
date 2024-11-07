package tn.lastdance.quizz.Interfaces;

import tn.lastdance.quizz.Entities.Option;

import java.util.List;

public interface IOptionService {
    public Option add(Option option);

    public Option findById(long id);

    public Option update(Option option);

    public String delete(long id);

    public List<Option> findAll();
}
