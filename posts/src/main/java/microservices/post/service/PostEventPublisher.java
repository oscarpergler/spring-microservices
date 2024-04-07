package microservices.post.service;

import microservices.post.entity.Post;
import microservices.post.entity.PostEvent;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostEventPublisher {

    private final AmqpTemplate amqpTemplate;

    private final String postsTopicExchange;

    public PostEventPublisher(final AmqpTemplate amqpTemplate, @Value("${amqp.exchange.post}") final String postsTopicExchange) {
        this.amqpTemplate = amqpTemplate;
        this.postsTopicExchange = postsTopicExchange;
    }

    /*
        We can add additional bindings later on such as "postDeleted",
        as of now posts cant be deleted to avoid problems with db consistency across services
    */
    @RegisterReflectionForBinding({PostEvent.class})
    public void postCreated(final Post post) {
        PostEvent event = buildEvent(post);
        String routingKey = "post.postCreated";

        log.info("Sending PostEvent: {}", event);
        amqpTemplate.convertAndSend(postsTopicExchange, routingKey, event); // Convert a Java object to an Amqp Message and send it to a specific exchange with a specific routing key.
    }

    private PostEvent buildEvent(final Post attempt) {
        return new PostEvent(attempt.getPostId(), attempt.getTitle(),
                attempt.getBodytext(), attempt.getUserId());
    }
}