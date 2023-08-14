package com.todolist.todolist.services.Contracts;

import java.util.List;

import com.todolist.todolist.entities.Todolist;

public interface TodolistService {
    List<Todolist> getAllTodolists();
    Todolist getOneTodolistById(int id);
    Todolist createOneTodolist(Todolist todolist);
    Todolist updateOneTodolist(int id, Todolist todolist);
    void deleteOneTodolist(int id);
    
}
