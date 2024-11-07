package tn.lastdance.posts.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.lastdance.posts.dto.CommentResponse;

import java.util.List;

@FeignClient(name="comment", url = "http://comment:8085")
public interface Commentclient {
    @GetMapping(value = "/api/comments/posts/{postId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<CommentResponse> findAllCommentsByPostId(@PathVariable("postId") String postId);

}
