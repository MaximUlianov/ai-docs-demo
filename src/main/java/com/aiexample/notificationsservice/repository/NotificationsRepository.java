package com.aiexample.notificationsservice.repository;

import com.aiexample.notificationsservice.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationsRepository extends JpaRepository<Notification, Long> {
}
