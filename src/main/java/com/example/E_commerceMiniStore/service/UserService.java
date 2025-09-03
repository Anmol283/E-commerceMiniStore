package com.example.E_commerceMiniStore.service;

import com.example.E_commerceMiniStore.entity.User;
import com.example.E_commerceMiniStore.repository.UserRepository;
import com.example.E_commerceMiniStore.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Registration
    public User register(User user){
        // You can add password encoding here
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }

    // Login
//    public String login(User user){
//        Optional<User> existing = userRepository.findByEmail(user.getEmail());
//        if(existing.isEmpty() || !existing.get().getPassword().equals(user.getPassword())){
//            throw new RuntimeException("Invalid credentials");
//        }
//        // Here you should generate JWT token including role
//        // For now, just returning a placeholder string
//        return "JWT_TOKEN_PLACEHOLDER";
//    }
    @Autowired
    private JwtService jwtService;

    public String login(User user){
        Optional<User> existing = userRepository.findByEmail(user.getEmail());
        if(existing.isEmpty() || !existing.get().getPassword().equals(user.getPassword())){
            throw new RuntimeException("Invalid credentials");
        }

        // generate actual JWT
        String token = jwtService.generateToken(existing.get().getEmail(), existing.get().getRole().name());
        return token;
    }

}
