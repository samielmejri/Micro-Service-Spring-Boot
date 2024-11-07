package tn.lastdance.quizz.Services;

import lombok.Builder;
import org.springframework.stereotype.Service;
import tn.lastdance.quizz.Entities.Tentative;
import tn.lastdance.quizz.Interfaces.ITentativeService;
import tn.lastdance.quizz.Repositories.TentativeRepository;

import java.util.List;

@Service
@Builder
public class TentativeService implements ITentativeService {
    private final TentativeRepository tentativeRepository;

    @Override
    public Tentative add(Tentative tentative) {
        return tentativeRepository.save(tentative);
    }

    @Override
    public Tentative findById(long id) {
        return tentativeRepository.findById(id).orElse(null);
    }

    @Override
    public Tentative update(Tentative tentative) {
        return tentativeRepository.save(tentative);
    }

    @Override
    public String delete(long id) {
        if (tentativeRepository.findById(id).orElse(null) == null) {
            return ("Tentative not found");
        }
        tentativeRepository.deleteById(id);
        return ("Tentative deleted");
    }

    @Override
    public List<Tentative> findAll() {
        return tentativeRepository.findAll();
    }
}
