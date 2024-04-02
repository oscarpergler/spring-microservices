package microservice.timeline.configuration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

@Configuration
public class AMQPConfiguration {

    // We've already created te exchange on the publisher side however to keep the services loosely coupled it is also created here
    @Bean
    public TopicExchange challengesTopicExchange(@Value("${amqp.exchange.post}") final String exchangeName) {
        return ExchangeBuilder.topicExchange(exchangeName).durable(true).build();
    }

    @Bean
    public Queue postQueue(@Value("${amqp.queue.postCreated}") final String queueName) {
        return QueueBuilder.durable(queueName).build();
    }

    @Bean
    public Binding postBinding(final Queue postQueue, final TopicExchange postsExchange) {
        return BindingBuilder.bind(postQueue)
                .to(postsExchange)
                .with("post.postCreated");
    }
}
