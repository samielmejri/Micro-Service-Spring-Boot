package tn.lastdance.posts.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.lastdance.posts.dto.CommentResponse;
import tn.lastdance.posts.dto.PostCommentResponse;
import tn.lastdance.posts.entity.Post;
import tn.lastdance.posts.http.Commentclient;
import tn.lastdance.posts.service.PostService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin("http://front:4200")
@RequestMapping(value = "/api/posts",consumes = "application/json",produces = "application/json")
public class PostController {

    private Commentclient commentclient;


    private PostService postService;
    @PostMapping
    public Post save(@RequestBody Post post){
        return  postService.save(post);
    }

    @GetMapping
    public List<Post> getPosts(){
         return postService.getPosts();
    }

    @GetMapping("{id}")
    public Post getPost(@PathVariable("id") String id){
        return postService.getPost(id);
    }

    @PutMapping("{id}")
    public Post updatePost(@RequestBody Post post,@PathVariable("id") String id){
        return postService.updatePost(post);
    }

    @DeleteMapping("{id}")
    public Post deletePost(@PathVariable("id") String id){
        Post deletedPost = postService.deletePost(id);

            return deletedPost;

    }


    @GetMapping("/forum/{id}")
    public List<Post> getPostsByFormuId(@PathVariable("id") Long id){

        return postService.getPostsByFormuId(id);
    }

    @GetMapping("/post/{postId}/comments")
    public PostCommentResponse getCommentsByPostId(@PathVariable("postId") String postId){
        List<CommentResponse>  commentResponses = commentclient.findAllCommentsByPostId(postId);
        Post post = postService.getPost(postId);

            return PostCommentResponse.builder()
                    .comments(commentResponses)
                    .title(post.getTitle())
                    .username(post.getUsername())
                    .content(post.getContent())
                    .postId(post.getPostId())
                    .build();


    }
}
