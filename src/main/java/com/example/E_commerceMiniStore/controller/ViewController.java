package com.example.E_commerceMiniStore.controller;

import com.example.E_commerceMiniStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @Autowired
    private ProductService productService;

    @GetMapping("/cart")
    public String cartPage() {
        return "cart"; // looks for templates/cart.html
    }
    // Root path - redirect to login
    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    // Login Page
    @GetMapping("/login")
    public String loginPage() {
        return "login";  // uses the JWT-enabled login.html
    }

    // Register Page
    @GetMapping("/register")
    public String registerPage() {
        return "register";  // looks for templates/register.html
    }

    // Dashboard Page (requires authentication)
    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "dashboard";  // uses the JWT-enabled dashboard.html
    }

    // Products Page (requires authentication)
    @GetMapping("/products")
    public String productsPage(Model model) {
        // Note: The actual product data will be loaded via JavaScript using JWT
        return "products";  // looks for templates/products.html
    }

    // Inventory Page (requires authentication)
    @GetMapping("/inventory")
    public String inventoryPage() {
        return "inventory"; // looks for templates/inventory.html
    }
}