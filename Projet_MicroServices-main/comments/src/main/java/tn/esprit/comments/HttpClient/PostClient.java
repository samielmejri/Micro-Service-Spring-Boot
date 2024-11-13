package tn.esprit.comments.HttpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="post", url = "http://post:8090")
public interface PostClient {

    @GetMapping(value = "/api/posts/comment/{forumId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<PostClient> findAllPostsByFormuId(@PathVariable("forumId") Long formuId);

}
