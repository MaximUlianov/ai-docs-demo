package com.aiexample.notificationsservice.configuration;

import com.aiexample.notificationsservice.messaging.NotificationMessage;
import com.aiexample.notificationsservice.messaging.NotificationsConsumer;
import com.aiexample.notificationsservice.messaging.NotificationsProducer;
import com.aiexample.notificationsservice.service.NotificationsService;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class MessagingConfig {

    public static final String NOTIFICATIONS_TOPIC_NAME = "notifications";

    @Bean
    NewTopic notificationsTopic() {
        return new NewTopic(NOTIFICATIONS_TOPIC_NAME, 1, (short) 1);
    }

    @Bean
    NotificationsProducer notificationsProducer(KafkaTemplate<String, NotificationMessage> kafkaTemplate) {
        return new NotificationsProducer(kafkaTemplate, NOTIFICATIONS_TOPIC_NAME);
    }

    @Bean
    NotificationsConsumer notificationListener(NotificationsService notificationsService) {
        return new NotificationsConsumer(notificationsService);
    }
}
