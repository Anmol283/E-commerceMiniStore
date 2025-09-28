package com.example.E_commerceMiniStore.controller;


import com.example.E_commerceMiniStore.entity.CartItem;
import com.example.E_commerceMiniStore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartItemController {

    @Autowired
    private CartItemService cartService;

    @GetMapping
    @PreAuthorize("hasRole('CUSTOMER')")
    public List<CartItem> getCartItems(@RequestParam Long userId){
        return cartService.getCartItems(userId);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('CUSTOMER')")
    public CartItem addToCart(@RequestBody CartItem item){
        return cartService.addToCart(item);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public CartItem updateCartItem(@PathVariable Long id, @RequestBody CartItem item){
        return cartService.updateCartItem(id, item);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public void removeCartItem(@PathVariable Long id){
        cartService.removeCartItem(id);
    }
}
