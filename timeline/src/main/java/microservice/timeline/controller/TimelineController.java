package microservice.timeline.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservice.timeline.entity.Timeline;
import microservice.timeline.service.TimelineService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// TODO: Get user by social graph

@Slf4j
@RequiredArgsConstructor
@RestController
public class TimelineController {

    private final TimelineService timelineService;

    @GetMapping("/timeline/{userId}")
    Optional<Timeline> getUserTimeline(@PathVariable Long userId) {
        return timelineService.getTimeline(userId);
    }

}
