package microservice.timeline.entity;

import jakarta.persistence.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.*;

@RedisHash("Timeline")
public class Timeline {
    @Id
    private String userId;
    private List<PostEvent> postEvents;
}
