package com.example.E_commerceMiniStore.controller;

import com.example.E_commerceMiniStore.entity.Order;
import com.example.E_commerceMiniStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/my")
    @PreAuthorize("hasRole('CUSTOMER')")
    public List<Order> getMyOrders(@RequestParam Long userId){
        return orderService.getOrdersByUser(userId);
    }

    @PostMapping("/checkout")
    @PreAuthorize("hasRole('CUSTOMER')")
    public Order checkout(@RequestParam Long userId){
        return orderService.checkout(userId);
    }
}
