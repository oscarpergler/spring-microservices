package microservices.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

/*
    User entity

    Here we use lombok annotations to help us write boilerplate code, allowing us to focus on
    what is important to the domain. Notice how postId and userId does not have setters, this is due to the fact
    that they are designed to be immutable, which makes consistency across services easier.
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Long postId;

    private String title;

    private String bodytext;

    private Long userId;

}
