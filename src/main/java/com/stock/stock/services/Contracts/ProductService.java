package com.stock.stock.services.Contracts;

import java.util.List;

import com.stock.stock.entities.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Product getOneProductById(int id);
    Product createOneProduct(Product product);
    Product updateOneProduct(int id, Product product);
    void deleteOneProduct(int id);
    void deleteAllProducts();
}
