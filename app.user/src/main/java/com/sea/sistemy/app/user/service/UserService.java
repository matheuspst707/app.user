package com.sea.sistemy.app.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sea.sistemy.app.user.model.Role;
import com.sea.sistemy.app.user.model.User;
import com.sea.sistemy.app.user.repositories.UserRepository;

@Service  
public class UserService implements UserDetailsService {  

    @Autowired  
    private UserRepository userRepository;  
    
    @Autowired  
    private PasswordEncoder passwordEncoder;  

    public User registerAdmin(String username, String password) {  
        User user = new User();  
        user.setUsername(username);  
        user.setPassword(passwordEncoder.encode(password)); // Criptografa a senha  
        user.setRole(Role.ROLE_ADMIN); // Define o papel como admin  
        return userRepository.save(user); // Salva o usuário no banco de dados  
    } 
      
    @Override  
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {  
        User user = userRepository.findByUsername(username);  
        if (user == null) {  
            throw new UsernameNotFoundException("User not found with username: " + username);  
        }  
        return org.springframework.security.core.userdetails.User  
                .withUsername(user.getUsername())  
                .password(user.getPassword())  
                .roles(user.getRole().name()) // Converte a role para String  
                .build();  
    }   
    
    

    // Método para salvar um usuário  
    public User save(User user) {  
        return userRepository.save(user);  
    }  

    // Método para buscar todos os usuários  
    public List<User> findAll() {  
        return userRepository.findAll();  
    }  

    // Método para buscar um usuário pelo ID  
    public User findById(Long id) {  
        return userRepository.findById(id).orElse(null); // Retorna null se não encontrar  
    }  

    // Método para encontrar um usuário pelo nome de usuário  
    public User findByUsername(String username) {  
        return userRepository.findByUsername(username);  
    }  

    // Método para atualizar um usuário  
    public User update(User user) {  
        return userRepository.save(user);  
    }  

    // Método para deletar um usuário pelo ID  
    public void delete(Long id) {  
        userRepository.deleteById(id);  
    }  
}
