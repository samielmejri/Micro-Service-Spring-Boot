package tn.lastdance.cours.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.lastdance.cours.Entity.Cours;
import tn.lastdance.cours.Reposiroty.CoursRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/api/cours")
public class CoursController {
    @Autowired
    CoursRepository coursRepository;
    @GetMapping("/coursall")
    public ResponseEntity<List<Cours>> getAllCours(@RequestParam(required = false) String title) {
        try {
            List<Cours> cours = new ArrayList<Cours>();

            if (title == null)
                coursRepository.findAll().forEach(cours::add);
            else
                coursRepository.findByTitleContaining(title).forEach(cours::add);

            if (cours.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cours, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/coursall/{id}")
    public ResponseEntity<Cours> getCourById(@PathVariable("id") long id) {
        Optional<Cours> coursData = coursRepository.findById(id);

        if (coursData.isPresent()) {
            return new ResponseEntity<>(coursData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/courspost")
    public ResponseEntity<Cours> createCours(@RequestBody Cours cours) {
        try {
            Cours _tutorial = coursRepository
                    .save(new Cours(cours.getTitle(), cours.getDescription(), cours.getImage(),cours.getRating()));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatecours/{id}")
    public ResponseEntity<Cours> updateCours(@PathVariable("id") long id, @RequestBody Cours tutorial) {
        Optional<Cours> tutorialData = coursRepository.findById(id);

        if (tutorialData.isPresent()) {
            Cours _tutorial = tutorialData.get();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setImage(tutorial.getImage());
            _tutorial.setRating(tutorial.getRating());

            return new ResponseEntity<>(coursRepository.save(_tutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletecours/{id}")
    public ResponseEntity<HttpStatus> deleteCour(@PathVariable("id") long id) {
        try {
            coursRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<HttpStatus> deleteAllCours() {
        try {
            coursRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
