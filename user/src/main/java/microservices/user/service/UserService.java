package microservices.user.service;

import microservices.user.entity.User;
import microservices.user.entity.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User verifyUser (UserDTO userDTO);

    List<User> findAll();

    Optional<User> getUser(Long userId);

    void deleteUser(Long userId);

}
