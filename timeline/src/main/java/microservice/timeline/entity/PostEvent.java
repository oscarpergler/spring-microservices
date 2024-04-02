package microservice.timeline.entity;

import lombok.Getter;
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
