package microservices.post.repository;

import microservices.post.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    Optional<Post> findById(final Long postId);

    List<Post> findByUserId(final Long userId);
}
