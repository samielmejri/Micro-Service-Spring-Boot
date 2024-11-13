package tn.lastdance.quizz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.lastdance.quizz.Entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}