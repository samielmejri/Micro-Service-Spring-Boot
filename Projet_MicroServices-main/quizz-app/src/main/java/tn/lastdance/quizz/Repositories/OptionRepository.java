package tn.lastdance.quizz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.lastdance.quizz.Entities.Option;

public interface OptionRepository extends JpaRepository<Option, Long> {
}