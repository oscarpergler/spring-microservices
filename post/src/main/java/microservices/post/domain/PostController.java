package microservices.post.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postRepository;

    @GetMapping("/all")
    List<Post> all() {
        return (List<Post>) postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable final Long id) {
        return postRepository.findById(id);
    }

    @GetMapping("/user/{id}")
    public List<Post> getPostByUserId(@PathVariable final Long id) { return postRepository.findByUserId(id); }

    @PostMapping("/create")
    Post createPost(@RequestBody Post newPost) { return postRepository.save(newPost); }

    @DeleteMapping("/{id}")
    void deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }

}
