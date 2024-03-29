package microservice.timeline.service;

import lombok.RequiredArgsConstructor;
import microservice.timeline.entity.PostEvent;
import microservice.timeline.entity.Timeline;
import microservice.timeline.repository.TimelineRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimelineServiceImpl implements TimelineService{

    private final TimelineRepository timelineRepository;

    @Override
    public Optional<Timeline> getTimeline(Long userId) {
        return timelineRepository.findById(userId);
    }

}
