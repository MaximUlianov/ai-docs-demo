package com.aiexample.notificationsservice.messaging;

public record NotificationMessage(String message) {
    public static NotificationMessage of(String message) {
        return new NotificationMessage(message);
    }
}
