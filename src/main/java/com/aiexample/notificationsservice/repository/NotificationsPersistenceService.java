package com.aiexample.notificationsservice.repository;

import com.aiexample.notificationsservice.domain.Notification;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class NotificationsPersistenceService {

    private final NotificationsRepository notificationsRepository;

    public void save(Notification notification) {
        notificationsRepository.save(notification);
    }

    public List<Notification> findAll() {
        return notificationsRepository.findAll();
    }
}
