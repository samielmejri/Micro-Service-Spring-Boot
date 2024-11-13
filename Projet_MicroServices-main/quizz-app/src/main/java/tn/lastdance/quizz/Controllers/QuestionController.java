package tn.lastdance.quizz.Controllers;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.lastdance.quizz.Entities.Question;
import tn.lastdance.quizz.Interfaces.IQuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/question")
@Builder
public class QuestionController {
    private final IQuestionService questionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Question> findAll() {
        return questionService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Question findById(@PathVariable("id") long id) {
        return questionService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Question add(@RequestBody Question question) {
        return questionService.add(question);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Question update(@RequestBody Question question) {
        return questionService.update(question);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") long id) {
        return questionService.delete(id);
    }
}
