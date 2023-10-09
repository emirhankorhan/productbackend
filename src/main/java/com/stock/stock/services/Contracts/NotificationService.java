package com.stock.stock.services.Contracts;

import java.util.List;

import com.stock.stock.entities.Notification;

public interface NotificationService {
    List<Notification> getAllNotifications();
    Notification createOneNotification(Notification notification);
    void deleteAllNotifications();
}