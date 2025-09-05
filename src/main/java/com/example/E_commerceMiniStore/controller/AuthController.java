package com.example.E_commerceMiniStore.controller;

import java.util.Map;
import java.util.HashMap;


import com.example.E_commerceMiniStore.entity.User;
import com.example.E_commerceMiniStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
        String token = userService.login(user); // returns JWT
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity
            .ok()
            .header("Content-Type", "application/json")
            .body(response);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }
}



