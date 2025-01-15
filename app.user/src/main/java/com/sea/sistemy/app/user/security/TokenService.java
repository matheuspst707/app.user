package com.sea.sistemy.app.user.security;  

import java.sql.Date;
import java.time.Instant;  
import java.time.LocalDateTime;  
import java.time.ZoneId;  
import org.springframework.beans.factory.annotation.Value;  
import org.springframework.stereotype.Service;  
import com.sea.sistemy.app.user.model.User;  
import com.auth0.jwt.JWT; // Não esqueça de importar  
import com.auth0.jwt.algorithms.Algorithm;  
import com.auth0.jwt.exceptions.JWTCreationException;  
import com.auth0.jwt.exceptions.JWTVerificationException;  

@Service  
public class TokenService {  
    @Value("${api.security.token.secret}")  
    private String secret;  

    public String generateToken(User user) {  
        try {  
            Algorithm algorithm = Algorithm.HMAC256(secret);  
            String token = JWT.create()  
                    .withIssuer("auth-api")  
                    .withSubject(user.getLogin())  
                    .withExpiresAt(Date.from(genExpirationDate())) // Conversão para Date  
                    .sign(algorithm);  
            return token;  
        } catch (JWTCreationException exception) {  
            throw new RuntimeException("Error while generating token", exception);  
        }  
    }    

    public boolean validateToken(String token) {  
        try {  
            JWT.require(Algorithm.HMAC256(secret))  
                    .withIssuer("auth-api")  
                    .build()  
                    .verify(token);  
            return true;  // Token válido  
        } catch (JWTVerificationException exception) {  
            return false;  // Token inválido  
        }  
    }  

    public String getUsernameFromToken(String token) {  
        try {  
            return JWT.require(Algorithm.HMAC256(secret))  
                    .withIssuer("auth-api")  
                    .build()  
                    .verify(token)  
                    .getSubject();  
        } catch (JWTVerificationException exception) {  
            return null;  // Retorna null se o token não for válido  
        }  
    }  

    private Instant genExpirationDate() {  
        return LocalDateTime.now()  
                .plusHours(2)  
                .atZone(ZoneId.of("UTC-3")) // Ajuste para o fuso horário  
                .toInstant(); // Converte para Instant  
    }  
}
