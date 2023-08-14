package com.todolist.todolist.presentation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.todolist.todolist.entities.Todolist;
import com.todolist.todolist.services.Contracts.TodolistService;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin
public class TodolistsController {
    private final TodolistService todolistService;

    public TodolistsController(@Qualifier("mysql") TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTodolists() {
        var todolists = todolistService.getAllTodolists();
        return new ResponseEntity<>(todolists, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Todolist> getOneTodolist(@PathVariable(name = "id") int id) {
        var todolist = todolistService.getOneTodolistById(id);
        return ResponseEntity.ok(todolist);
    }

    @PostMapping
    public ResponseEntity<?> createOneTodolist(@RequestBody Todolist todolist) {
        todolistService.createOneTodolist(todolist);
        return new ResponseEntity<>(todolist, HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> updateOneTodolist(@PathVariable(name = "id", required = true) int id,
            @RequestBody Todolist todolist) {
        todolistService.updateOneTodolist(id, todolist);
        return ResponseEntity.ok()
                .header("location", "http://localhost:8082/api/todos/" + todolist.getId())
                .body(todolist);
    }

    @DeleteMapping(path = "{id}")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteOneTodolist(@PathVariable(name = "id", required = true) int id) {
        todolistService.deleteOneTodolist(id);
        return ResponseEntity.noContent().build();
    }

    // @ExceptionHandler(NotFoundException.class)
    // @ResponseBody
    // public ResponseEntity<Object> handleException(NotFoundException ex, WebRequest request) {

    //     var errordetails = ErrorDetails
    //             .builder()
    //             .statusCode(404)
    //             .message(ex.getMessage())
    //             .path(request.getDescription(false))
    //             .build();
    //     return new ResponseEntity<>(errordetails, HttpStatus.NOT_FOUND);
    // }

}
