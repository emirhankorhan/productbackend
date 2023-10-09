package com.stock.stock.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Notification {
    @Id
    @GeneratedValue
    @Column(name = "notification_id")
    private int id;

    @Column(name = "notification_text")
    private String notificationText;
}