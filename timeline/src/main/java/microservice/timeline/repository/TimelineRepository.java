package microservice.timeline.repository;

import microservice.timeline.entity.Timeline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimelineRepository extends CrudRepository<Timeline, Long> { }
