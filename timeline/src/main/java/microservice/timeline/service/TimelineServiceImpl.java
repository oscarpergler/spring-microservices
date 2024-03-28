package microservice.timeline.service;

import microservice.timeline.entity.PostEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineServiceImpl implements TimelineService{
    @Override
    public List<PostEvent> getTimelineByUserId(Long userId) {
        return null;
    }

    @Override
    public PostEvent appendPostToTimeline(PostEvent postEvent) {
        return null;
    }
}
