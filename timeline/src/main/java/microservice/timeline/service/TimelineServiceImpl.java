package microservice.timeline.service;

import lombok.RequiredArgsConstructor;
import microservice.timeline.entity.PostEvent;
import microservice.timeline.entity.Timeline;
import microservice.timeline.repository.TimelineRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimelineServiceImpl implements TimelineService{

    private final TimelineRepository timelineRepository;

    @Override
    public Optional<Timeline> getTimeline(Long userId) {
        return timelineRepository.findById(userId);
    }

    @Override
    public Optional<Timeline> createTimeline(PostEvent postEvent) {
        Long userId = postEvent.getUserId();

        // If it doesn't already exist; create a new timeline with the given postEvent
        if (!timelineRepository.existsById(userId)){
            List<PostEvent> postEvents = new ArrayList<>();
            postEvents.add(postEvent);
            Timeline newTimeline = new Timeline(userId, postEvents);
            return Optional.of(timelineRepository.save(newTimeline));
        }
        // Otherwise; try adding the new event to the timeline belonging to said user
        else{
            Optional<Timeline> timelineOptional = timelineRepository.findById(userId);
            try {
                Timeline timeline = timelineOptional.orElseThrow(() -> new Exception("Timeline not found for user: " + userId));
                timeline.getPostEvents().add(postEvent);
                return Optional.of(timelineRepository.save(timeline));
            } catch (Exception e) {
                e.printStackTrace();
                return Optional.empty();
            }
        }
    }

}
