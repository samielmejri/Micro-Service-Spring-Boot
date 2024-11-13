package tn.lastdance.quizz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.lastdance.quizz.Entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}