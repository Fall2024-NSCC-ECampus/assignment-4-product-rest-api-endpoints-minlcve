package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ProductNotFoundException(id));  // Throw custom exception if not found
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct == null) {
            throw new ProductNotFoundException(id);  // Throw exception if product to update is not found
        }
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        if (!productService.deleteProduct(id)) {
            throw new ProductNotFoundException(id);  // Throw exception if product to delete is not found
        }
        return ResponseEntity.ok("Product deleted successfully");
    }
}
