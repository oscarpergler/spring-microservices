package microservice.timeline.entity;

import lombok.Value;

@Value
public class PostEvent {

    Long postId;

    String title;

    String bodytext;

    Long userId;

}
