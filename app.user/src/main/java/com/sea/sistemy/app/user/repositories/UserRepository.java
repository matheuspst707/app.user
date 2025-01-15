package com.sea.sistemy.app.user.repositories;  

import java.util.Optional;  

import org.springframework.data.jpa.repository.JpaRepository;  
import com.sea.sistemy.app.user.model.User;  

public interface UserRepository extends JpaRepository<User, String> {  
    User findByLogin(String login); // Altera UserDetails para User  
    User findByUsername(String username);  
    Optional<User> findById(String id);  
    void deleteById(String id);  
}    
