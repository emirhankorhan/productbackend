package com.todolist.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.todolist.entities.Todolist;

public interface TodolistRepository extends JpaRepository<Todolist, Integer>{
    
}
