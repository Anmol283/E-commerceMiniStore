package com.example.E_commerceMiniStore.repository;


import com.example.E_commerceMiniStore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId); // fetch orders of a customer
}
