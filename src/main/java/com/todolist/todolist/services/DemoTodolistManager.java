package com.todolist.todolist.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.todolist.todolist.entities.Todolist;
import com.todolist.todolist.services.Contracts.TodolistService;


@Service
@Repository("demo")
public class DemoTodolistManager implements TodolistService {

    @Override
    public List<Todolist> getAllTodolists() {
        var list = new ArrayList<Todolist>();
        list.add(new Todolist(1, "kahve iç", "haziran", "23323", "32"));
        list.add(new Todolist(2, "ödev yap", "temmuz", "232323", "32323"));
        return list;
    }

    @Override
    public Todolist getOneTodolistById(int id) {
        return new Todolist(2, "ders çalış", "ocak", "23233", "32332");

    }

    @Override
    public Todolist createOneTodolist(Todolist todolist){
        return new Todolist(2, "yürüyüş yap", "haziran", "23232", "32323");
    }

    @Override
    public Todolist updateOneTodolist(int id, Todolist todolist) {
        
        return null;
    }

    @Override
    public void deleteOneTodolist(int id) {
        
        
    }
    
}
