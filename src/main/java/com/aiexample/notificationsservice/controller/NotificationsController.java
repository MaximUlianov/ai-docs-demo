package com.aiexample.notificationsservice.controller;

import com.aiexample.notificationsservice.messaging.NotificationsProducer;
import com.aiexample.notificationsservice.model.DemoSendNotificationRequest;
import com.aiexample.notificationsservice.model.DemoSendNotificationResponse;
import com.aiexample.notificationsservice.service.NotificationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NotificationsController implements NotificationsApi {

    private final NotificationsProducer notificationsProducer;
    private final NotificationsService notificationsService;

    @Override
    public ResponseEntity<Void> sendNotification(DemoSendNotificationRequest request) {
        notificationsProducer.send(request.getMessage());

        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<DemoSendNotificationResponse> getAllNotifications() {
        DemoSendNotificationResponse response = new DemoSendNotificationResponse();
        response.setNotifications(notificationsService.getAllNotifications());

        return ResponseEntity.ok(response);
    }
}
