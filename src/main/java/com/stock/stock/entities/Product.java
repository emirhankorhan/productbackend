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
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private int id;

    @Column(name = "input_text")
    private String inputText;

    @Column(name = "input_date")
    private String inputDate;

    @Column(name = "input_code")
    private String inputCode;

    @Column(name = "input_piece")
    private String inputPiece;

    
    
}
