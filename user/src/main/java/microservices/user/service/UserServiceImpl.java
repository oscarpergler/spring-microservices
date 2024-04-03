package microservices.user.service;

import lombok.RequiredArgsConstructor;
import microservices.user.entity.User;
import microservices.user.entity.UserDTO;
import microservices.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User verifyUser(UserDTO userDTO) {
        return userRepository.save(new User(null, userDTO.getUsername(), userDTO.getRole(), userDTO.getPassword()));
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

}
