package microservices.user.repository;

import java.util.Optional;

import microservices.user.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {



}
