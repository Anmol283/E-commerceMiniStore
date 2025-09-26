package com.example.E_commerceMiniStore.repository;


import com.example.E_commerceMiniStore.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(Long userId); // fetch cart items for a customer
}
