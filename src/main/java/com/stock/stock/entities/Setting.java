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
@Table(name = "settings")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Setting {
    @Id
    @GeneratedValue
    @Column(name = "setting_id")
    private int id;

    @Column(name = "setting_danger")
    private int settingDanger;    
}