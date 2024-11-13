package tn.lastdance.quizz.Services;

import lombok.Builder;
import org.springframework.stereotype.Service;
import tn.lastdance.quizz.Entities.Option;
import tn.lastdance.quizz.Interfaces.IOptionService;
import tn.lastdance.quizz.Repositories.OptionRepository;

import java.util.List;

@Service
@Builder
public class OptionService implements IOptionService {
    private final OptionRepository optionRepository;

    @Override
    public Option add(Option option) {
        return optionRepository.save(option);
    }

    @Override
    public Option findById(long id) {
        return optionRepository.findById(id).orElse(null);
    }

    @Override
    public Option update(Option option) {
        return optionRepository.save(option);
    }

    @Override
    public String delete(long id) {
        if (optionRepository.findById(id).orElse(null) == null) {
            return ("Option not found");
        }
        optionRepository.deleteById(id);
        return ("Option deleted");
    }

    @Override
    public List<Option> findAll() {
        return optionRepository.findAll();
    }
}
