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
    public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
        User dbUser = userService.validateUser(user); // check email & password
        String token = userService.login(dbUser);     // generate JWT

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("role", dbUser.getRole().name());
        response.put("fullName", dbUser.getFullName());
        response.put("email", dbUser.getEmail());

        return ResponseEntity.ok(response);
    }


    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody User user) {
        try {
            User savedUser = userService.register(user);

            Map<String, String> response = new HashMap<>();
            response.put("message", "User registered successfully!");
            response.put("email", savedUser.getEmail());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("message", e.getMessage()));
        }
    }

}



