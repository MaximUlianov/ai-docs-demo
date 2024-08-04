package com.aiexample.notificationsservice.service;

import com.aiexample.notificationsservice.domain.Notification;
import com.aiexample.notificationsservice.repository.NotificationsPersistenceService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class NotificationsService {

    private final NotificationsPersistenceService notificationsPersistenceService;

    public void saveNotification(String message) {
        notificationsPersistenceService.save(Notification.of(message));
    }

    public List<String> getAllNotifications() {
        return notificationsPersistenceService.findAll()
                .stream()
                .map(Notification::getMessage)
                .toList();
    }
}
