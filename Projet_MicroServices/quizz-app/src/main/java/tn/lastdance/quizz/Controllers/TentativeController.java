package tn.lastdance.quizz.Controllers;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.lastdance.quizz.Entities.Tentative;
import tn.lastdance.quizz.Interfaces.ITentativeService;

import java.util.List;

@RestController
@Builder
@RequestMapping("/api/tentative")
public class TentativeController {
    private final ITentativeService tentativeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Tentative> findAll() {
        return tentativeService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tentative findById(long id) {
        return tentativeService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tentative add(@RequestBody Tentative tentative) {
        return tentativeService.add(tentative);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Tentative update(@RequestBody Tentative tentative) {
        return tentativeService.update(tentative);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") long id) {
        return tentativeService.delete(id);
    }

}
