package com.stock.stock.entities.exceptions;

public class OperationNotFoundException extends NotFoundException{

    public OperationNotFoundException(int id) {
        super(String.format("Operations with id: %d could not found!", id));
    }
    
}