package com.example.E_commerceMiniStore.service;

import com.example.E_commerceMiniStore.entity.Role;
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
    public User register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        if (user.getRole() == null) {
            user.setRole(Role.CUSTOMER); // default role
        }
        if (user.getFullName() == null || user.getFullName().isEmpty()) {
            user.setFullName(user.getEmail().split("@")[0]); // fallback fullName
        }

        return userRepository.save(user);
    }
    // ✅ validate user credentials
    public User validateUser(User user) {
        Optional<User> existing = userRepository.findByEmail(user.getEmail());
        if (existing.isEmpty() || !existing.get().getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return existing.get(); // return full User object from DB
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

    public String login(User user) {
        Optional<User> existing = userRepository.findByEmail(user.getEmail());
        if (existing.isEmpty() || !existing.get().getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // pass full User to JWT service
        return jwtService.generateToken(existing.get());
    }

}
