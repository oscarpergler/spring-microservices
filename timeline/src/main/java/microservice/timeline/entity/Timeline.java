package microservice.timeline.entity;

import org.springframework.data.annotation.Id;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.util.*;

@RedisHash("Timeline")
@AllArgsConstructor
@NoArgsConstructor
public class Timeline {

    @Id
    @Getter
    private Long userId;

    @Getter
    private List<PostEvent> postEvents;

}
