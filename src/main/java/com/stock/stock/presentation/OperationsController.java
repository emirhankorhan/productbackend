package com.stock.stock.presentation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stock.stock.entities.Operation;
import com.stock.stock.services.Contracts.OperationService;

@RestController
@RequestMapping("/api/operations")
@CrossOrigin
public class OperationsController {
    private final OperationService operationService;

    public OperationsController(@Qualifier("mysqloperation") OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping
    public ResponseEntity<?> getAllOperations() {
        var operations = operationService.getAllOperations();
        return new ResponseEntity<>(operations, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Operation> getOneOperationById(@PathVariable(name = "id") int id) {
        var operation = operationService.getOneOperationById(id);
        return ResponseEntity.ok(operation);
    }

    @PostMapping
    public ResponseEntity<?> createOneOperation(@RequestBody Operation operation) {
        operationService.createOneOperation(operation);
        return new ResponseEntity<>(operation, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteOneOperation(@PathVariable(name = "id", required = true) int id) {
        operationService.deleteOneOperation(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteAllOperations() {
        operationService.deleteAllOperations(); // Tüm ögeleri silen metodu çağırın
        return ResponseEntity.noContent().build();
    }

}