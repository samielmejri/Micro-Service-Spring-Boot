package tn.esprit.ms.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.ms.Entities.Post;
import tn.esprit.ms.dto.PostResponse;

import javax.ws.rs.Path;
import java.util.List;

@FeignClient(name="post", url = "http://post:8090")
public interface PostClient {

    @GetMapping(value = "/api/posts/forum/{forumId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<PostResponse> findAllPostsByFormuId(@PathVariable("forumId") Long formuId);

}
