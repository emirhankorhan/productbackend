package com.stock.stock.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.stock.stock.entities.Product;
import com.stock.stock.services.Contracts.ProductService;


@Service
@Repository("demo")
public class DemoProductManager implements ProductService {

    @Override
    public List<Product> getAllProducts() {
        var list = new ArrayList<Product>();
        list.add(new Product(1, "kahve iç", "haziran", "da", 23323, 32, 23, "ayakkabı"));
        list.add(new Product(2, "ödev yap", "sds", "temmuz", 232323, 32323, 3232, "kadın giyim"));
        return list;
    }

    @Override
    public Product getOneProductById(int id) {
        return new Product(2, "ders çalış", "sdsd", "ocak", 23233, 32332, 3232, "kadın giyim");

    }

    @Override
    public Product createOneProduct(Product product){
        return new Product(2, "yürüyüş yap", "dsdsd", "haziran", 23232, 32323, 3232, "kadın giyim");
    }

    @Override
    public Product updateOneProduct(int id, Product product) {
        
        return null;
    }

    @Override
    public void deleteOneProduct(int id) {
        
        
    }

    @Override
    public void deleteAllProducts() {
        
        
    }
    
}
