package tn.lastdance.quizz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.lastdance.quizz.Entities.Tentative;

public interface TentativeRepository extends JpaRepository<Tentative, Long> {
}