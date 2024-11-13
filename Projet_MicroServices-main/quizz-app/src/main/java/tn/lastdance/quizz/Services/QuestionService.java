package tn.lastdance.quizz.Services;

import lombok.Builder;
import org.springframework.stereotype.Service;
import tn.lastdance.quizz.Entities.Question;
import tn.lastdance.quizz.Interfaces.IQuestionService;
import tn.lastdance.quizz.Repositories.QuestionRepository;

import java.util.List;

@Service
@Builder
public class QuestionService implements IQuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question findById(long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public Question add(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question update(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public String delete(long id) {
        if (questionRepository.findById(id).orElse(null) == null) {
            return ("Question not found");
        }
        questionRepository.deleteById(id);
        return ("Question deleted");
    }
}
