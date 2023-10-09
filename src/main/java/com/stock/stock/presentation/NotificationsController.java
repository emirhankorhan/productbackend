package com.stock.stock.presentation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stock.stock.entities.Notification;
import com.stock.stock.services.Contracts.NotificationService;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin
public class NotificationsController {
    private final NotificationService notificationService;

    public NotificationsController(@Qualifier("mysqlnotification") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public ResponseEntity<?> getAllNotifications() {
        var notifications = notificationService.getAllNotifications();
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createOneNotification(@RequestBody Notification notification) {
        notificationService.createOneNotification(notification);
        return new ResponseEntity<>(notification, HttpStatus.CREATED);
    }

    @DeleteMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteAllNotifications() {
        notificationService.deleteAllNotifications();
        return ResponseEntity.noContent().build();
    }

}