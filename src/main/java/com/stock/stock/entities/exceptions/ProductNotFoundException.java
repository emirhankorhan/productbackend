package com.stock.stock.entities.exceptions;

public class ProductNotFoundException extends NotFoundException{

    public ProductNotFoundException(int id) {
        super(String.format("Products with id: %d could not found!", id));
    }
    
}
