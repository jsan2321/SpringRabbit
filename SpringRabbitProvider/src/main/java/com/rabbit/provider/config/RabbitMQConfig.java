package com.rabbit.provider.config;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up RabbitMQ components such as exchanges, message converters,
 * and the RabbitTemplate.
 */
@Configuration
public class RabbitMQConfig {

    // Name of the topic exchange used for routing messages
    public static final String EXCHANGE_NAME = "message_exchange";

    // Routing key for messages related to color
    public static final String ROUTING_KEY_COLOR = "color_routing_key";

    // Routing key for messages related to shape
    public static final String ROUTING_KEY_SHAPE = "shape_routing_key";

    /**
     * Creates and configures a TopicExchange bean.
     * A TopicExchange routes messages to queues based on matching between a message routing key
     * and the pattern that was used to bind a queue to an exchange.
     *
     * @return A TopicExchange instance with the specified name.
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    /**
     * Creates a MessageConverter bean to convert messages to and from JSON format.
     * This uses the Jackson2JsonMessageConverter for JSON serialization and deserialization.
     *
     * @return A Jackson2JsonMessageConverter instance.
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Creates and configures an AmqpTemplate bean using RabbitTemplate.
     * The RabbitTemplate is a helper class that simplifies synchronous RabbitMQ access.
     * It is configured with a ConnectionFactory and a MessageConverter.
     *
     * @param connectionFactory The ConnectionFactory used to create connections to RabbitMQ.
     * @return A configured RabbitTemplate instance.
     */
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final var template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter()); // Set the message converter
        return template;
    }


}
