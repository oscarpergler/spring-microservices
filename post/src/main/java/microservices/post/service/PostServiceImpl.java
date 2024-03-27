package microservices.post.service;

import lombok.RequiredArgsConstructor;
import microservices.post.entity.Post;
import microservices.post.entity.PostDTO;
import microservices.post.repository.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public Post verifyPost(PostDTO postDTO) {
        return postRepository.save(new Post(null, postDTO.getTitle(), postDTO.getBodytext(), postDTO.getUserId()));
    }
}
