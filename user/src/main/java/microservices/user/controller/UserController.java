package microservices.user.controller;

import java.util.List;
import java.util.Optional;

import microservices.user.repository.UserRepository;
import microservices.user.entity.User;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/all")
    List<User> all() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable final Long id) {
        return userRepository.findById(id);
    }

    @PostMapping("/create")
    User createUser(@RequestBody User newUsers) {
        return userRepository.save(newUsers);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}
