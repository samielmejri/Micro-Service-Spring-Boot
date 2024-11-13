package tn.lastdance.quizz.Interfaces;

import tn.lastdance.quizz.Entities.Tentative;

import java.util.List;

public interface ITentativeService {
    public Tentative add(Tentative tentative);

    public Tentative findById(long id);

    public Tentative update(Tentative tentative);

    public String delete(long id);

    public List<Tentative> findAll();
}
