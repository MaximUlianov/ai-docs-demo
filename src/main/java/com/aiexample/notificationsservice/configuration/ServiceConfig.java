package com.aiexample.notificationsservice.configuration;

import com.aiexample.notificationsservice.repository.NotificationsRepository;
import com.aiexample.notificationsservice.repository.NotificationsPersistenceService;
import com.aiexample.notificationsservice.service.NotificationsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    NotificationsPersistenceService notificationsPersistenceService(NotificationsRepository notificationsRepository) {
        return new NotificationsPersistenceService(notificationsRepository);
    }

    @Bean
    NotificationsService notificationsService(NotificationsPersistenceService notificationsPersistenceService) {
        return new NotificationsService(notificationsPersistenceService);
    }
}
