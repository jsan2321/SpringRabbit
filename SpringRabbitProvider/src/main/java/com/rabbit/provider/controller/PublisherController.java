package com.rabbit.provider.controller;

import com.rabbit.provider.config.RabbitMQConfig;
import com.rabbit.provider.model.Color;
import com.rabbit.provider.model.Shape;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class responsible for publishing messages to RabbitMQ.
 * It exposes REST endpoints to publish messages related to colors and shapes.
 */
@Controller
@RequiredArgsConstructor // Lombok annotation to generate a constructor with required fields
@RequestMapping(path = "publish") // Base path for all endpoints
public class PublisherController {

    /**
     * RabbitTemplate is used to send messages to RabbitMQ
     *
     * The @RequiredArgsConstructor annotation from Lombok generates a constructor that initializes the rabbitTemplate field.
     */
    //@Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * Endpoint to publish a color message to RabbitMQ.
     * The message is sent to the exchange with the color routing key.
     *
     * @param color The Color object to be published as a message.
     * @return A confirmation message indicating the color message was published successfully.
     */
    @PostMapping(path = "color")
    public  String publishColor(@RequestBody Color color) {
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
    @PostMapping(path = "shape")
    public  String publishColor(@RequestBody Shape shape) {
        this.rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_SHAPE, shape);
        return "Shape message published successfully";
    }

    // The @RequestBody annotation is used to bind the incoming JSON payload to the Color or Shape object.
}
