package com.example.E_commerceMiniStore.controller;


import com.example.E_commerceMiniStore.entity.Product;
import com.example.E_commerceMiniStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // All users can view products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    // Only manager can add product
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    public Product addProduct(@RequestBody Product product){
        return productService.add(product);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public void deleteProduct(@PathVariable Long id){
        productService.delete(id);
    }
}