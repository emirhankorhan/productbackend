package com.todolist.todolist.services;

import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.todolist.todolist.entities.Todolist;
import com.todolist.todolist.entities.exceptions.TodolistNotFoundException;
import com.todolist.todolist.repositories.TodolistRepository;
import com.todolist.todolist.services.Contracts.TodolistService;


@Service
@Repository("mysql")
public class TodolistManager implements TodolistService{

    private final TodolistRepository todolistRepository;

    public TodolistManager(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public List<Todolist> getAllTodolists() {
        return todolistRepository.findAll();
        
    }

    @Override
    public Todolist getOneTodolistById(int id) {
        return todolistRepository.findById(id).orElseThrow(() -> new TodolistNotFoundException(id));
        
    }

    @Override
    public Todolist createOneTodolist(Todolist todolist) {
        return todolistRepository.save(todolist);
    }

    @Override
    public Todolist updateOneTodolist(int id, Todolist todolist) {
        if(todolist.getId()!=id)
            throw new RuntimeException("Please check id!");

        var entity = getOneTodolistById(id);
        
        entity.setInputText(todolist.getInputText());
        entity.setInputDate(todolist.getInputDate());
        entity.setInputCode(todolist.getInputCode());
        entity.setInputPiece(todolist.getInputPiece());

        
        
        return todolistRepository.save(entity);
    }

    @Override
    public void deleteOneTodolist(int id) {
        todolistRepository.deleteById(id);
        
    }
    
}
