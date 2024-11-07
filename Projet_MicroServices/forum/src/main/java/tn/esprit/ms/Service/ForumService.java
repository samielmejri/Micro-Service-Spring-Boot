package tn.esprit.ms.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ms.Entities.Forum;
import tn.esprit.ms.Repository.*;
import java.util.*;


@Service
@AllArgsConstructor
public class ForumService implements IForumService {

    ForumRepository forumRepository;

    @Override
    public List<Forum> getForums() {
        return forumRepository.findAll();
    }

    @Override
    public Forum getForumByID(Long idDep) {

        return forumRepository.findById(idDep).orElse(null);
    }

    @Override
    public Forum saveForum(Forum forum) {
        return forumRepository.save(forum);
    }

    @Override
    public List<Forum> saveForums(List<Forum> forums) {
        return forumRepository.saveAll(forums);
    }

    @Override
    public String deleteForum(Long idForum) {
        forumRepository.deleteById(idForum);
        return "Forum supprimé !" + idForum;
    }

    @Override
    public Forum upadateForum(Long idForum, Forum forum) {
        Forum toUpdateForum = forumRepository.findById(idForum).get();

        if (Objects.nonNull(forum.getTitre()) && !"".equalsIgnoreCase(forum.getTitre())) {
            toUpdateForum.setTitre(forum.getTitre());
            toUpdateForum.setDescription(forum.getDescription());
        }
        return forumRepository.save(toUpdateForum);
    }

    @Override
    public Set<Forum> retrieveForumByPost(Long idUniversite) {
        return null;
    }

    @Override
    public Forum addPostToForum(Forum deprt, Long idUniversite) {
        return null;
    }

    @Override
    public String nbrDepart() {
        return null;
    }

    @Override
    public Long nbrEtudByDepart() {
        return null;
    }

    @Override
    public long nbrEtudByOneDepart(String nomDepart) {
        return 0;
    }

    @Override
    public List<Forum> triDepartement() {
        return null;
    }

    @Override
    public List<Forum> getDepartByNom(String Nom) {
        return null;
    }


}

