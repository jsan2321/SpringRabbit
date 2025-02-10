package com.rabbit.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up RabbitMQ components such as queues, exchanges, bindings,
 * and message converters. This class defines the necessary beans for RabbitMQ communication.
 */
@Configuration
public class RabbitMQConfig {

    // Name of the topic exchange used for routing messages
    public static final String EXCHANGE_NAME = "message_exchange";

    // Routing key for messages related to color
    public static final String ROUTING_KEY_COLOR = "color_routing_key";

    // Routing key for messages related to shape
    public static final String ROUTING_KEY_SHAPE = "shape_routing_key";

    // Name of the queue for color messages
    public static final String QUEUE_COLOR = "color_queue";

    // Name of the queue for shape messages
    public static final String QUEUE_SHAPE = "shape_queue";

    /**
     * Creates a queue for color messages.
     *
     * @return A Queue instance for color messages.
     */
    @Bean
    public Queue queueColor() {
        return new Queue(QUEUE_COLOR);
    }

    /**
     * Creates a queue for shape messages.
     *
     * @return A Queue instance for shape messages.
     */
    @Bean
    public Queue queueShape() {
        return new Queue(QUEUE_SHAPE);
    }

    /**
     * Binds the color queue to the topic exchange using the color routing key.
     *
     * @param queueColor    The color queue to bind.
     * @param topicExchange The topic exchange to bind to.
     * @return A Binding instance linking the color queue to the exchange.
     */
    @Bean
    public Binding bindingColorExchange(Queue queueColor, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueColor)
                             .to(topicExchange)
                             .with(ROUTING_KEY_COLOR);
    }

    /**
     * Binds the shape queue to the topic exchange using the shape routing key.
     *
     * @param queueShape    The shape queue to bind.
     * @param topicExchange The topic exchange to bind to.
     * @return A Binding instance linking the shape queue to the exchange.
     */
    @Bean
    public Binding bindingShapeExchange(Queue queueShape, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueShape)
                             .to(topicExchange)
                             .with(ROUTING_KEY_SHAPE);
    }

    /**
     * Creates a topic exchange for routing messages.
     *
     * @return A TopicExchange instance with the specified name.
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    /**
     * Creates a message converter to serialize and deserialize messages to/from JSON.
     *
     * @return A Jackson2JsonMessageConverter instance.
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Configures and returns an AmqpTemplate (RabbitTemplate) for sending messages to RabbitMQ.
     * The template is configured with a connection factory and a message converter.
     *
     * @param connectionFactory The connection factory for RabbitMQ.
     * @return A configured RabbitTemplate instance.
     */
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final var template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter()); // Set the message converter
        return template;
    }
}