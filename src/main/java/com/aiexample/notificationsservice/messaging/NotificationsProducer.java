package com.aiexample.notificationsservice.messaging;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

@Slf4j
@RequiredArgsConstructor
public class NotificationsProducer {

    private final KafkaTemplate<String, NotificationMessage> kafkaTemplate;

    private final String topicName;

    @SneakyThrows
    public void send(String message) {
        kafkaTemplate.send(topicName, NotificationMessage.of(message))
                .exceptionally(this::handleException)
                .get();
    }

    private SendResult<String, NotificationMessage> handleException(Throwable throwable) {
        log.error("Error sending notification", throwable);
        return null;
    }
}
