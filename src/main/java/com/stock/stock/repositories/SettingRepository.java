package com.stock.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.stock.entities.Setting;

public interface SettingRepository extends JpaRepository<Setting, Integer>{
    
}
