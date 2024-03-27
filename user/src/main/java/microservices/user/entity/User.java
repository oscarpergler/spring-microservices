package microservices.user.entity;

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
    @Getter
    private Long userId;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private UserRole role;

    @Getter
    private String password;

}
