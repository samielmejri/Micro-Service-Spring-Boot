package tn.esprit.ms.Service;

import tn.esprit.ms.Entities.Forum;

import java.util.List;
import java.util.Set;

public interface IForumService {

    public List<Forum> getForums();
    public Forum getForumByID(Long idDep);
    public Forum saveForum(Forum departement);
    public List<Forum> saveForums(List<Forum> forums);
    public String deleteForum(Long idDepartement);
    public Forum upadateForum(Long idDepartement, Forum departement);

    public Set<Forum> retrieveForumByPost(Long idUniversite);

    public Forum addPostToForum(Forum deprt, Long idUniversite);

    public String nbrDepart();

    public Long nbrEtudByDepart();

    public long nbrEtudByOneDepart(String nomDepart);


    public List<Forum> triDepartement();

    public List<Forum> getDepartByNom(String Nom);




}
