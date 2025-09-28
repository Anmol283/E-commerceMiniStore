// src/main/java/com/example/api_gateway/controller/FallbackController.java
package com.example.api_gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FallbackController {

    @GetMapping("/fallback/ecommerce")
    public ResponseEntity<Map<String, Object>> ecommerceFallback() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "E-commerce service is currently unavailable. Please try again later.");
        response.put("fallback", true);
        response.put("status", "SERVICE_UNAVAILABLE");
        response.put("timestamp", System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }
}