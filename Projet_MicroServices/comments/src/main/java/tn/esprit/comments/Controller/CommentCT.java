package tn.esprit.comments.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.comments.Entity.Comment;
import tn.esprit.comments.Service.CommentService;


import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/comments")

public class CommentCT {

    @Autowired
    private CommentService commentService;



    @GetMapping("/all")
    public List<Comment> getAllComments() {

        return commentService.getAllComments();
    }



    @GetMapping("/{commentId}")
    public Comment getComment(@PathVariable Long commentId) {

        return commentService.getCommentById(commentId);
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {

        commentService.deleteComment(commentId);
    }

    @GetMapping("/posts/{postId}")
    public List<Comment> getCommentByPostId(@PathVariable("postId") String postId) {

        return commentService.getCommentByPostId(postId);
    }
}
