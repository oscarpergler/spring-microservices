package microservices.post.service;

import microservices.post.entity.Post;
import microservices.post.entity.PostDTO;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> findAll();

    Post createPost(PostDTO postDTO);


    Optional<Post> getPost(Long postId);

}
