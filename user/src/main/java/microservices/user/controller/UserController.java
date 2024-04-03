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
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable final Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/create")
    User createUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.verifyUser(userDTO);
    }

}
