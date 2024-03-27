package microservices.post.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservices.post.entity.Post;
import microservices.post.entity.PostDTO;
import microservices.post.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    /*
    @GetMapping("/all")
    List<Post> all() {
        return (List<Post>) postRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Post> getPostById(@PathVariable final Long id) {
        return postRepository.findById(id);
    }

    @GetMapping("/user/{id}")
    List<Post> getPostByUserId(@PathVariable final Long id) { return postRepository.findByUserId(id); }
*/
    @PostMapping("/create")
    ResponseEntity<Post> createPost(@RequestBody @Valid PostDTO postDTO) {
        return ResponseEntity.ok(postService.verifyPost(postDTO));
    }

    /*
    @DeleteMapping("/{id}")
    void deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }
    */

}
