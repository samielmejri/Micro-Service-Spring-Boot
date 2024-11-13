package tn.lastdance.quizz.Controllers;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.lastdance.quizz.Entities.Option;
import tn.lastdance.quizz.Interfaces.IOptionService;

import java.util.List;

@RestController
@RequestMapping("/api/option")
@Builder
public class OptionController {

    private final IOptionService optionService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Option>> findall() {
        return new ResponseEntity<>(optionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Option> findById(@PathVariable("id") long id) {
        return new ResponseEntity<>(optionService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Option> add(@RequestBody Option option) {
        return new ResponseEntity<>(optionService.add(option), HttpStatus.OK);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Option> update(@RequestBody Option option) {
        return new ResponseEntity<>(optionService.update(option), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") long id) {
        return optionService.delete(id);
    }
}
