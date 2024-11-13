package tn.lastdance.posts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.lastdance.posts.entity.Post;
import tn.lastdance.posts.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService  {
    @Autowired
    private PostRepository postRepository;
    public Post save(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPost(String id) {
        Post post = postRepository.findByPostId(id);
        return  post;

    }


    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    public Post deletePost(String id) {
        Post post = postRepository.findByPostId(id);
            postRepository.deleteById(id);
            return post;

    }

    public List<Post> getPostsByFormuId(Long id) {
        return postRepository.findByForumId(id);

    }
}
