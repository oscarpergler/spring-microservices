package microservices.user.domain;
import lombok.*;

/*
    User entity - User domain:
    
    Here we use lombok to help us write boilerplate code, allowing us to focus on
    what is important to the domain.
*/
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private Long id;
    private String alias;
}
