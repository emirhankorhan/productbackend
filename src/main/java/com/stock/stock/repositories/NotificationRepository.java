package com.stock.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.stock.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer>{
    
}