package microservice.timeline.service;

import microservice.timeline.entity.PostEvent;

import java.util.List;

public interface TimelineService {

    List<PostEvent> getTimelineByUserId(Long userId);

    PostEvent appendPostToTimeline(PostEvent postEvent);

}
