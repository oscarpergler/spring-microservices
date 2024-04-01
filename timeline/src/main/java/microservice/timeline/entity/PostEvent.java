package microservice.timeline.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
public class PostEvent {

    @Getter
    Long postId;

    @Getter
    String title;

    @Getter
    String bodytext;

    @Getter
    Long userId;

}
