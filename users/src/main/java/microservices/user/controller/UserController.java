package microservices.user.controller;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import microservices.user.entity.UserDTO;
import microservices.user.entity.User;
import microservices.user.service.UserService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable final Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/users")
    User createUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.verifyUser(userDTO);
    }

}
