package com.example.api_gateway.fallback;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/ecommerce")
    @PostMapping("/ecommerce")
    @PutMapping("/ecommerce")
    @DeleteMapping("/ecommerce")
    public ResponseEntity<Map<String, Object>> ecommerceFallback() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "E-commerce service is currently unavailable. Please try again later.");
        response.put("status", "SERVICE_UNAVAILABLE");
        response.put("timestamp", System.currentTimeMillis());
        response.put("fallback", true);
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }
}