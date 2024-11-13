package tn.lastdance.posts.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.lastdance.posts.entity.Post;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
   Post  findByPostId(String id);
    List<Post> findByForumId(Long id);


}
