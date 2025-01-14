package com.sea.sistemy.app.user.controllers;  

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.security.authentication.AuthenticationManager;  
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;  
import org.springframework.security.core.userdetails.UserDetails;  
import org.springframework.security.core.userdetails.UserDetailsService;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.http.ResponseEntity;  

import com.sea.sistemy.app.user.DTO.AuthenticationDTO;  
import com.sea.sistemy.app.user.DTO.AuthenticationResponse;  
import com.sea.sistemy.app.user.DTO.RegisterDTO; // Novo DTO para registro  
import com.sea.sistemy.app.user.model.User;  
import com.sea.sistemy.app.user.service.UserService; // Serviço de usuário  
import com.sea.sistemy.app.user.security.JwtTokenProvider;  

@RestController  
public class AuthController {  

    @Autowired  
    private AuthenticationManager authenticationManager;  

    @Autowired  
    private JwtTokenProvider jwtTokenProvider;  

    @Autowired  
    private UserDetailsService userDetailsService;  

    @Autowired  
    private UserService userService; // Adicionado para registrar usuários  

    @PostMapping("/auth/login")  
    public AuthenticationResponse authenticate(@RequestBody AuthenticationDTO request) {  
        // Autentica o usuário  
        authenticationManager.authenticate(  
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())  
        );  

        // Carrega os detalhes do usuário  
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());  

        // Gera o token JWT  
        String token = jwtTokenProvider.generateToken(userDetails.getUsername());  

        // Retorna a resposta com o token  
        return new AuthenticationResponse(token);  
    }  

    @PostMapping("/auth/register/admin")  
    public ResponseEntity<User> registerAdmin(@RequestBody RegisterDTO registerDTO) {  
        User newAdmin = userService.registerAdmin(registerDTO.getUsername(), registerDTO.getPassword());  
        return ResponseEntity.ok(newAdmin);  
    }  
}
