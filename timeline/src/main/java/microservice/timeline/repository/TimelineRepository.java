package microservice.timeline.repository;

import microservice.timeline.entity.Timeline;
import org.springframework.data.repository.CrudRepository;

public interface TimelineRepository extends CrudRepository<Timeline, Long> { }
