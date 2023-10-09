package com.stock.stock.services;

import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.stock.stock.entities.Notification;
import com.stock.stock.repositories.NotificationRepository;
import com.stock.stock.services.Contracts.NotificationService;


@Service
@Repository("mysqlnotification")
public class NotificationManager implements NotificationService{

    private final NotificationRepository notificationRepository;

    public NotificationManager(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
        
    }

    @Override
    public Notification createOneNotification (Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void deleteAllNotifications(){
        notificationRepository.deleteAll();
    }
    
}