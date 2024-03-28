package microservices.post.service;

import lombok.RequiredArgsConstructor;
import microservices.post.entity.Post;
import microservices.post.entity.PostDTO;
import microservices.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    private final PostEventPublisher postEventPublisher;

    @Override
    public List<Post> findAll() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public Post verifyPost(PostDTO postDTO) {
        Post storedPost = postRepository.save(new Post(null, postDTO.getTitle(), postDTO.getBodytext(), postDTO.getUserId()));
        postEventPublisher.postCreated(storedPost);
        return storedPost;
    }

    @Override
    public List<Post> getPostsFromUser(Long userId) {
        return postRepository.findByUserId(userId);
    }

    @Override
    public Optional<Post> getPost(Long postId) {
        return postRepository.findById(postId);
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
