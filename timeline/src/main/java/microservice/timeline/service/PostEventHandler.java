package microservice.timeline.service;

import jakarta.transaction.Transactional;
import microservice.timeline.entity.PostEvent;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class PostEventHandler {

    private final TimelineService tlService;

    @RabbitListener(queues = "${amqp.queue.postCreated}")
    void handlePostReceived(final PostEvent event) {
        log.info("PostEvent received: {}", event.getPostId());
        try {
            tlService.createTimeline(event);
        } catch (final Exception e) {
            log.error("Error when trying to process PostEvent", e);
            // Avoids the event to be re-queued and reprocessed.
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
    
}
