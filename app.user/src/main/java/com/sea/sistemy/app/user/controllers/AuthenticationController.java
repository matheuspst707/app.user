package com.sea.sistemy.app.user.controllers;  

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.sea.sistemy.app.user.security.TokenService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sea.sistemy.app.user.DTO.AuthenticationDTO;
import com.sea.sistemy.app.user.DTO.LoginResponseDTO;
import com.sea.sistemy.app.user.DTO.RegisterDTO; // Novo DTO para registro  
import com.sea.sistemy.app.user.model.User;
import com.sea.sistemy.app.user.repositories.UserRepository;  
import org.springframework.security.core.userdetails.UserDetails;  

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")  
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {  
        // 1. Criar um objeto de autenticação  
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());  
        
        // 2. Autenticar o usuário  
        Authentication auth = this.authenticationManager.authenticate(usernamePassword);  
        
        // 3. Obter os detalhes do usuário autenticado  
        UserDetails userDetails = (UserDetails) auth.getPrincipal();  
        
        // 4. Usar o repositório para encontrar o usuário correspondente  
        User user = repository.findByLogin(userDetails.getUsername()); // Substitua por findByUsername se necessário  
        
        // 5. Gerar o token usando o TokenService  
        String token = tokenService.generateToken(user); // Aqui você chama corretamente o método no objeto User  
        
        // 6. Retornar a resposta contendo o token  
        return ResponseEntity.ok(new LoginResponseDTO(token));  
    }   

    @PostMapping("/register")  
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {  
        if (this.repository.findByLogin(data.getLogin()) != null) {  
            return ResponseEntity.badRequest().build(); // Retorna erro se o login já existir  
        }  

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());  
        User newUser = new User(data.getLogin(), encryptedPassword, data.getRole());  
        this.repository.save(newUser);  
        
        return ResponseEntity.ok().build(); // Retorna sucesso  
    } 
}
