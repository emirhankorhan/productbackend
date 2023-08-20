package com.stock.stock.presentation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.stock.stock.entities.Product;
import com.stock.stock.services.Contracts.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {
    private final ProductService productService;

    public ProductsController(@Qualifier("mysql") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        var products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Product> getOneProduct(@PathVariable(name = "id") int id) {
        var product = productService.getOneProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<?> createOneProduct(@RequestBody Product product) {
        productService.createOneProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> updateOneProduct(@PathVariable(name = "id", required = true) int id,
            @RequestBody Product product) {
        productService.updateOneProduct(id, product);
        return ResponseEntity.ok()
                .header("location", "http://localhost:8082/api/todos/" + product.getId())
                .body(product);
    }

    @DeleteMapping(path = "{id}")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteOneProduct(@PathVariable(name = "id", required = true) int id) {
        productService.deleteOneProduct(id);
        return ResponseEntity.noContent().build();
    }

    // @ExceptionHandler(NotFoundException.class)
    // @ResponseBody
    // public ResponseEntity<Object> handleException(NotFoundException ex, WebRequest request) {

    //     var errordetails = ErrorDetails
    //             .builder()
    //             .statusCode(404)
    //             .message(ex.getMessage())
    //             .path(request.getDescription(false))
    //             .build();
    //     return new ResponseEntity<>(errordetails, HttpStatus.NOT_FOUND);
    // }

}
