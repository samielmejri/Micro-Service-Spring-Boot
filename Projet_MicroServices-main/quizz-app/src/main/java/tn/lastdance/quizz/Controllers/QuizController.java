package tn.lastdance.quizz.Controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.lastdance.quizz.Entities.Quiz;
import tn.lastdance.quizz.Interfaces.IQuizService;

import java.util.List;

@RestController
@Builder
@CrossOrigin
@RequestMapping("/api/quiz")
public class QuizController {
    private final IQuizService quizService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Quiz>> findAll() {
        return new ResponseEntity<>(quizService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz) {
        return new ResponseEntity<>(quizService.add(quiz), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Quiz> findById(@PathVariable long id) {
        return new ResponseEntity<>(quizService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz) {
        return new ResponseEntity<>(quizService.update(quiz), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable long id) {
        return quizService.delete(id);
    }

}
