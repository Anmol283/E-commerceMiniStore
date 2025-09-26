package com.example.E_commerceMiniStore.service;

import com.example.E_commerceMiniStore.entity.CartItem;
import com.example.E_commerceMiniStore.entity.Order;
import com.example.E_commerceMiniStore.repository.CartItemRepository;
import com.example.E_commerceMiniStore.repository.OrderRepository;
import com.example.E_commerceMiniStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Order> getOrdersByUser(Long userId){
        return orderRepository.findByUserId(userId);
    }

    public Order checkout(Long userId){
        List<CartItem> cartItems = cartItemRepository.findByUserId(userId);
        if(cartItems.isEmpty()){
            throw new RuntimeException("Cart is empty");
        }

        BigDecimal total = BigDecimal.ZERO;

        for(CartItem item : cartItems){
            total = total.add(productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"))
                    .getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setTotal(total);
        order.setCreatedAt(Instant.now());

        // Save order
        Order savedOrder = orderRepository.save(order);

        // Clear cart
        cartItemRepository.deleteAll(cartItems);

        return savedOrder;
    }
}