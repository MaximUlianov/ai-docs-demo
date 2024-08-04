package com.aiexample.notificationsservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "notification_id")
    private long id;

    @Column(name = "message")
    private String message;

    @Version
    @Column(name = "version")
    private long version;

    public static Notification of(String message) {
        Notification notification = new Notification();
        notification.setMessage(message);

        return notification;
    }
}
