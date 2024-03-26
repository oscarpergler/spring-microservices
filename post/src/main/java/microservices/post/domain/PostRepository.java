package microservices.post.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Long> {

    Optional<Post> findById(final Long postId);

    List<Post> findByUserId(final Long userId);
}
