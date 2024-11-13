package tn.lastdance.cours.Reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.lastdance.cours.Entity.Cours;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours, Long> {


    List<Cours> findByTitleContaining(String title);
}