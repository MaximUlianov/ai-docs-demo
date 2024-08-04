package com.aiexample.notificationsservice.messaging;

import com.aiexample.notificationsservice.service.NotificationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;

import static com.aiexample.notificationsservice.configuration.MessagingConfig.NOTIFICATIONS_TOPIC_NAME;

@RequiredArgsConstructor
public class NotificationsConsumer {

    private final NotificationsService notificationsService;

    @KafkaListener(
            topics = NOTIFICATIONS_TOPIC_NAME,
            groupId = "demoproject_group_id",
            concurrency = "1"
    )
    public void consume(NotificationMessage notification) {
        notificationsService.saveNotification(notification.message());
    }
}
