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

    public User registerAdmin(String login, String password) {  
        User user = new User();  
        user.setLogin(login);  
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
    public User findById(String id) {  
        return userRepository.findById(id).orElse(null); // Retorna null se não encontrar  
    }  

    // Método para encontrar um usuário pelo Login  
    public User findByLogin(String login) {  
        UserDetails userDetails = userRepository.findByLogin(login);  
        if (userDetails instanceof User) {  
            return (User) userDetails; // Casting para User  
        }  
        return null;  
    }  

    // Método para atualizar um usuário  
    public User update(User user) {  
        return userRepository.save(user);  
    }  

    // Método para deletar um usuário pelo ID  
    public void delete(String id) {  
        userRepository.deleteById(id);  
    }  
}
