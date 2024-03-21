package microservices.user.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

/*
    User entity

    Here we use lombok annotations to help us write boilerplate code, allowing us to focus on
    what is important to the domain.
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    private String username;

    private UserRole role;

    private String password;

}
