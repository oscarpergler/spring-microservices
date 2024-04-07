package microservices.user.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

@Value
public class UserDTO {

    @Length(min = 1, max = 10, message = "A username must be between 1 and 10 characters")
    @NotBlank
    String username;

    // TODO: Validate this
    UserRole role;

    @Length(min = 3, max = 16, message = "A password must be between 3 and 16 characters")
    @NotBlank
    String password;
}
