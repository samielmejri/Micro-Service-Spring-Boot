package tn.lastdance.quizz.Services;

import lombok.Builder;
import org.springframework.stereotype.Service;
import tn.lastdance.quizz.Entities.Quiz;
import tn.lastdance.quizz.Interfaces.IQuizService;
import tn.lastdance.quizz.Repositories.QuizRepository;

import java.util.List;

@Service
@Builder
public class QuizService implements IQuizService {

    private final QuizRepository quizRepository;

    @Override
    public Quiz add(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz findById(long id) {
        return this.quizRepository.findById(id).orElse(null);
    }

    @Override
    public List<Quiz> findAll() {
        return this.quizRepository.findAll();
    }

    @Override
    public Quiz update(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public String delete(long id) {
        if (this.quizRepository.findById(id).orElse(null) == null) {
            return ("Quiz not found");
        }
        this.quizRepository.deleteById(id);
        return ("Quiz deleted");
    }


}
