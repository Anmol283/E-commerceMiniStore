package com.example.E_commerceMiniStore.service;

import com.example.E_commerceMiniStore.entity.CartItem;
import com.example.E_commerceMiniStore.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getCartItems(Long userId){
        return cartItemRepository.findByUserId(userId);
    }

    public CartItem addToCart(CartItem item){
        return cartItemRepository.save(item);
    }

    public CartItem updateCartItem(Long id, CartItem item){
        CartItem existing = cartItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        existing.setQuantity(item.getQuantity());
        return cartItemRepository.save(existing);
    }

    public void removeCartItem(Long id){
        cartItemRepository.deleteById(id);
    }
}
