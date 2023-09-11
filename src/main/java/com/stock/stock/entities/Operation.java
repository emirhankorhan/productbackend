package com.stock.stock.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "operations")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Operation {
    @Id
    @GeneratedValue
    @Column(name = "operation_id")
    private int id;

    @Column(name = "operation_name")
    private String operationName;

    @Column(name = "operation_company")
    private String operationCompany;

    @Column(name = "operation_product")
    private String operationProduct;

    @Column(name = "operation_date")
    private String operationDate;

    @Column(name = "operation_piece")
    private int operationPiece;  
    
    @Column(name = "operation_totalfee")
    private double operationTotalfee; 
}