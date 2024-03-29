package microservice.timeline.service;

import microservice.timeline.entity.PostEvent;
import microservice.timeline.entity.Timeline;
import java.util.Optional;

public interface TimelineService {

    Optional<Timeline> getTimeline(Long userId);

}
