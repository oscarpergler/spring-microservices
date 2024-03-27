package microservices.post.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;
import lombok.Value;

/*
    Data transform object used when receiving createPost requests from user.
*/
@Value
public class PostDTO {

    @Length(min = 1, max = 10, message = "A title may not be longer than 10 characters")
    @NotBlank
    String title;

    @Length(min = 1, max = 100, message = "A bodytext may not be longer than 100 characters")
    @NotBlank
    String bodytext;

    @Positive(message = "Invalid userId: userId must be a positive number")
    Long userId;
}
