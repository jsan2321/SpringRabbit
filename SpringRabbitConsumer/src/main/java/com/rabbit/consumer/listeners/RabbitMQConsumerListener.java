package com.rabbit.consumer.listeners;

import com.rabbit.consumer.config.RabbitMQConfig;
import com.rabbit.consumer.model.Color;
import com.rabbit.consumer.model.Shape;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMQConsumerListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_COLOR)
    public void readColorMessage(Color color) {
        log.info("RabbitMQConsumerListener readColorMessage...");
        log.info("Received color: {}", color);
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_SHAPE)
    public void readColorMessage(Shape shape) {
        log.info("RabbitMQConsumerListener readShapeMessage...");
        log.info("Received shape: {}", shape);
    }

}
