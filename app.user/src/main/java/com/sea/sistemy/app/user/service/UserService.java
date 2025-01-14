package com.sea.sistemy.app.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sea.sistemy.app.user.model.User;
import com.sea.sistemy.app.user.repositories.UserRepository;

@Service  
public class UserService {  
	
	
	
	
    @Autowired  
    private UserRepository userRepository;  

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
