package microservices.post.service;

import microservices.post.entity.Post;
import microservices.post.entity.PostDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Post verifyPost(PostDTO postDTO);

}
