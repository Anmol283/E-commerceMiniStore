package com.example.E_commerceMiniStore.service;


import com.example.E_commerceMiniStore.entity.Product;
import com.example.E_commerceMiniStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product add(Product product){
        return productRepository.save(product);
    }

    public Product update(Long id, Product product){
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        return productRepository.save(existing);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}