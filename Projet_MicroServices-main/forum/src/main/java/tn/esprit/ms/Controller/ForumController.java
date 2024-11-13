package tn.esprit.ms.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ms.Client.PostClient;
import tn.esprit.ms.Entities.Forum;
import tn.esprit.ms.Service.*;
import tn.esprit.ms.dto.ForumPostReponse;
import tn.esprit.ms.dto.PostResponse;

import java.util.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/forum")
public class ForumController {
    private PostClient postClient;
    IForumService forumService;
    @GetMapping("/getForums")
    public List<Forum> getForums(){
        return forumService.getForums();
    }

    @GetMapping("/getForumById/{idForum}")
    public Forum getForumById(@PathVariable("idForum") Long idForum){
        return forumService.getForumByID(idForum);
    }

    @PostMapping("/addForum")
    public Forum saveForum(@RequestBody Forum forum){
        return forumService.saveForum(forum);
    }

    @PostMapping("/addForums")
    public List<Forum> saveForums (@RequestBody List<Forum> forums){
        return forumService.saveForums(forums);
    }

    @PutMapping("/updateForum/{idForum}")
    public Forum updateForum (@PathVariable("idForum") Long idForum, @RequestBody Forum forum){
        return forumService.upadateForum(idForum, forum);
    }

    @DeleteMapping("/deleteForum/{idForum}")
    public String deleteForum (@PathVariable Long idForum){
        return forumService.deleteForum(idForum);
    }

    @GetMapping("/getPostsForumById/{idForum}")
    public ForumPostReponse getPostsForumById(@PathVariable("idForum") Long idForum){

        List<PostResponse> postResponses =  postClient.findAllPostsByFormuId(idForum);
        Forum forum = forumService.getForumByID(idForum);
        return  ForumPostReponse.builder()
                .postResponses(postResponses)
                .description(forum.getDescription())
                .titre(forum.getTitre())
                .id(forum.getId())
                .build();

    }

}
