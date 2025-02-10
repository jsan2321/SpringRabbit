package com.rabbit.provider.controller;

import com.rabbit.provider.config.RabbitMQConfig;
import com.rabbit.provider.model.Color;
import com.rabbit.provider.model.Shape;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for publishing messages to RabbitMQ.
 * It exposes REST endpoints to publish messages related to colors and shapes.
 */
@RestController
@RequestMapping(path = "/publish") // Base path for all endpoints in this controller
public class PublisherController {

    /**
     * RabbitTemplate is used to send messages to RabbitMQ.
     * It is injected via constructor injection.
     */
    private final RabbitTemplate rabbitTemplate;

    /**
     * Constructor for dependency injection of RabbitTemplate.
     *
     * @param rabbitTemplate The RabbitTemplate instance to be used for sending messages.
     */
    @Autowired
    public PublisherController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Endpoint to publish a color message to RabbitMQ.
     * The message is sent to the exchange with the color routing key.
     *
     * @param color The Color object to be published as a message.
     * @return A confirmation message indicating the color message was published successfully.
     */
    @PostMapping(path = "/color")
    public String publishColor(@RequestBody Color color) {
        this.rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_COLOR, color);
        return "Color message published successfully";
    }

    /**
     * Endpoint to publish a shape message to RabbitMQ.
     * The message is sent to the exchange with the shape routing key.
     *
     * @param shape The Shape object to be published as a message.
     * @return A confirmation message indicating the shape message was published successfully.
     */
    @PostMapping(path = "/shape")
    public String publishShape(@RequestBody Shape shape) {
        this.rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_SHAPE, shape);
        return "Shape message published successfully";
    }
}