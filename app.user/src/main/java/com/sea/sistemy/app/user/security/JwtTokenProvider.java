package com.sea.sistemy.app.user.security;

import java.util.Date; // Para representar data e hora  
import java.util.HashMap; // Para usar HashMap  
import java.util.Map; // Para usar Map  

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts; // Para manipulação de JWT  
import io.jsonwebtoken.SignatureAlgorithm; // Para algoritmos de assinatura JWT  
import org.springframework.beans.factory.annotation.Value; // Para injeção de valores  
import org.springframework.stereotype.Component; // Para anotação de componentes 


@Component  
public class JwtTokenProvider {  

    @Value("${jwt.secret}")  
    private String secret; // Chave secreta para assinar o token  

    @Value("${jwt.expiration}")  
    private long expiration; // Tempo de expiração do token em milissegundos  

    // Método para gerar um token JWT  
    public String generateToken(String username) {  
        Map<String, Object> claims = new HashMap<>();  
        return Jwts.builder()  
                .setClaims(claims)  
                .setSubject(username)  
                .setIssuedAt(new Date(System.currentTimeMillis()))  
                .setExpiration(new Date(System.currentTimeMillis() + expiration))  
                .signWith(SignatureAlgorithm.HS512, secret)  
                .compact();  
    }  

    // Método para validar um token JWT  
    public boolean validateToken(String token) {  
        try {  
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);  
            return true;  
        } catch (Exception e) {  
            return false;  
        }  
    }  

    // Método para obter o username a partir do token  
    public String getUsernameFromToken(String token) {  
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();  
        return claims.getSubject();  
    }  
}
