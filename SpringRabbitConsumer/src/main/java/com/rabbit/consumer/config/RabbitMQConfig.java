package com.rabbit.consumer.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "message_exchange";

    public static final String ROUTING_KEY_COLOR = "color_routing_key";

    public static final String ROUTING_KEY_SHAPE = "shape_routing_key";
    public static final String QUEUE_COLOR = "color_queue";
    public static final String QUEUE_SHAPE = "shape_queue";

    @Bean
    public Queue queueColor() {
        return new Queue(QUEUE_COLOR);
    }

    @Bean
    public Queue queueShape() {
        return new Queue(QUEUE_SHAPE);
    }

    @Bean
    public TopicExchange exchangeColor() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingColorExchange(Queue queueColor, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueColor)
                             .to(topicExchange)
                             .with(ROUTING_KEY_COLOR);
    }

    @Bean
    public Binding bindingShapeExchange(Queue queueShape, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueShape)
                             .to(topicExchange)
                             .with(ROUTING_KEY_SHAPE);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final var template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter()); // Set the message converter
        return template;
    }

}
