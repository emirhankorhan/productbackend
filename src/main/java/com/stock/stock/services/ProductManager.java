package com.stock.stock.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.stock.stock.entities.Product;
import com.stock.stock.entities.exceptions.ProductNotFoundException;
import com.stock.stock.repositories.ProductRepository;
import com.stock.stock.services.Contracts.ProductService;


@Service
@Repository("mysql")
public class ProductManager implements ProductService{

    private final ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
        
    }

    @Override
    public Product getOneProductById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        
    }

    @Override
    public Product createOneProduct (Product product) {
        return productRepository.save(product);
    }

    // @Override
    // public Product updateOneProduct(int id, Product product) {
    //     if(product.getId()!=id)
    //         throw new RuntimeException("Please check id!");

    //     var entity = getOneProductById(id);
        
    //     entity.setInputText(product.getInputText());
    //     entity.setInputDate(product.getInputDate());
    //     entity.setInputComment(product.getInputComment());
    //     entity.setInputCode(product.getInputCode());
    //     entity.setInputPiece(product.getInputPiece());

        
        
    //     return productRepository.save(entity);
    // }

    @Override
    public Product updateOneProduct(int id, Product newProductData) {
        // Önce veritabanında güncellenecek Setting nesnesini bulun
        Product existingProduct = productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Setting not found with id: " + id));

        // Yeni verileri kullanarak varolan Setting nesnesini güncelleyin

        existingProduct.setInputText(newProductData.getInputText());
        existingProduct.setInputDate(newProductData.getInputDate());
        existingProduct.setInputComment(newProductData.getInputComment());
        existingProduct.setInputCode(newProductData.getInputCode());
        existingProduct.setInputPiece(newProductData.getInputPiece());
        existingProduct.setInputPrice(newProductData.getInputPrice());
        existingProduct.setInputCategory(newProductData.getInputCategory());

        // Güncellenmiş Setting nesnesini veritabanına kaydedin
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteOneProduct(int id) {
        productRepository.deleteById(id);
        
    }

    @Override
    public void deleteAllProducts(){
        productRepository.deleteAll();
    }
    
}
