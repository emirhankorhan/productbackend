package com.stock.stock.services.Contracts;

import java.util.List;

import com.stock.stock.entities.Operation;

public interface OperationService {
    List<Operation> getAllOperations();
    Operation getOneOperationById(int id);
    Operation createOneOperation(Operation operation);
    void deleteOneOperation(int id);
    void deleteAllOperations();
}