package com.stock.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.stock.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Integer>{
    
}
