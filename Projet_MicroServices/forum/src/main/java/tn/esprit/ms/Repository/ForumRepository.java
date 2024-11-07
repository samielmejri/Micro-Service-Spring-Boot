package tn.esprit.ms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ms.Entities.*;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Long> {

    Forum findByTitre(String titre);


}
