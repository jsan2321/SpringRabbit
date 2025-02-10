package com.rabbit.consumer.listeners;

import com.rabbit.consumer.config.RabbitMQConfig;
import com.rabbit.consumer.model.Color;
import com.rabbit.consumer.model.Shape;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Service class that listens to RabbitMQ queues and processes incoming messages.
 * This class contains methods to consume messages from the color and shape queues.
 */
@Service
@RequiredArgsConstructor // Lombok annotation to generate a constructor with required fields
public class RabbitMQConsumerListener {

    // Logger for logging messages
    private static final Logger log = LoggerFactory.getLogger(RabbitMQConsumerListener.class);

    /**
     * Listens to the color queue and processes incoming color messages.
     * This method is triggered whenever a message is published to the color queue.
     *
     * @param color The Color object received from the queue.
     */
    @RabbitListener(queues = RabbitMQConfig.QUEUE_COLOR)
    public void readColorMessage(Color color) {
        log.info("RabbitMQConsumerListener readColorMessage...");
        log.info("Received color: {}", color);
        log.info("Received color: Name = {}, Hexadecimal = {}", color.getName(), color.getHex());
    }

    /**
     * Listens to the shape queue and processes incoming shape messages.
     * This method is triggered whenever a message is published to the shape queue.
     *
     * @param shape The Shape object received from the queue.
     */
    @RabbitListener(queues = RabbitMQConfig.QUEUE_SHAPE)
    public void readShapeMessage(Shape shape) {
        log.info("RabbitMQConsumerListener readShapeMessage...");
        log.info("Received shape: {}", shape);
        log.info("Received shape: Name = {}, Sides = {}", shape.getName(), shape.getNumberOfSides());
    }
}