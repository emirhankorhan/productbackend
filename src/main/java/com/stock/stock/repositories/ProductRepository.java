package com.stock.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.stock.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}
