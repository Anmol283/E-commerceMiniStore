package com.example.E_commerceMiniStore.repository;


import com.example.E_commerceMiniStore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Optional: add custom queries if needed
}