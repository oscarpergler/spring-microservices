package microservices.user.domain;

import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/{userId}")
    public Optional<User> getUsersByIdList(@PathVariable final Long userId) {
        return userRepository.findById(userId);
    }

}
