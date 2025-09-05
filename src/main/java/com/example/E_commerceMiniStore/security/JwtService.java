package com.example.E_commerceMiniStore.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;

@Service
public class JwtService {

    // Secure key loaded from application.properties (must be at least 32 chars for HS256)
    @Value("${jwt.secret}")
    private String SECRET_KEY;
    @Value("${jwt.expirationMs}")
    private long EXPIRATION_MS = 1000 * 60 * 60; // 1 hour

    public String generateToken(String email, String role) {
    return Jwts.builder()
        .setSubject(email)
        .claim("role", role)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
        .signWith(getSigningKey(), SignatureAlgorithm.HS256)
        .compact();
    }

    private java.security.Key getSigningKey() {
    // Use UTF-8 bytes for the secret key (ensure at least 32 chars)
    return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String extractRole(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
