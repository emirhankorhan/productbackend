package com.todolist.todolist.entities.exceptions;

public class TodolistNotFoundException extends NotFoundException{

    public TodolistNotFoundException(int id) {
        super(String.format("Todos with id: %d could not found!", id));
    }
    
}
