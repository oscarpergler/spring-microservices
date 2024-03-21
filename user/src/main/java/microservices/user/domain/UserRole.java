package microservices.user.domain;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
  Enum with different types of user roles
*/
@RequiredArgsConstructor
@Getter
public enum UserRole {

    USER("User"),
    VERIFIED("Verified"),
    ADMIN("Admin");

    private final String description;
}
