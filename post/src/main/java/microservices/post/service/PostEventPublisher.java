package microservices.post.service;

import microservices.post.entity.Post;
import microservices.post.entity.PostEvent;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class PostEventPublisher {

    private final AmqpTemplate amqpTemplate;

    private final String postsTopicExchange;

    public PostEventPublisher(final AmqpTemplate amqpTemplate, @Value("${amqp.exchange.new-posts}") final String postsTopicExchange) {
        this.amqpTemplate = amqpTemplate;
        this.postsTopicExchange = postsTopicExchange;
    }

    public void postCreated(final Post post) {
        PostEvent event = buildEvent(post);
        amqpTemplate.convertAndSend(postsTopicExchange, event);
    }

    private PostEvent buildEvent(final Post attempt) {
        return new PostEvent(attempt.getPostId(), attempt.getTitle(),
                attempt.getBodytext(), attempt.getUserId());
    }
}