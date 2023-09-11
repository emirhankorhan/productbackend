package com.stock.stock.services;

import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.stock.stock.entities.Operation;
import com.stock.stock.entities.exceptions.OperationNotFoundException;
import com.stock.stock.repositories.OperationRepository;
import com.stock.stock.services.Contracts.OperationService;


@Service
@Repository("mysqloperation")
public class OperationManager implements OperationService{

    private final OperationRepository operationRepository;

    public OperationManager(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
        
    }

    @Override
    public Operation getOneOperationById(int id) {
        return operationRepository.findById(id).orElseThrow(() -> new OperationNotFoundException(id));
        
    }

    @Override
    public Operation createOneOperation (Operation operation) {
        return operationRepository.save(operation);
    }

    @Override
    public void deleteOneOperation(int id) {
        operationRepository.deleteById(id);
        
    }

    @Override
    public void deleteAllOperations(){
        operationRepository.deleteAll();
    }
    
}