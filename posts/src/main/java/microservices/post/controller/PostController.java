package microservices.post.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservices.post.entity.Post;
import microservices.post.entity.PostDTO;
import microservices.post.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/all")
    List<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    Optional<Post> getPostById(@PathVariable final Long id) {
        return postService.getPost(id);
    }

    @PostMapping("/create")
    ResponseEntity<Post> createPost(@RequestBody @Valid PostDTO postDTO) {
        return ResponseEntity.ok(postService.createPost(postDTO));
    }

}