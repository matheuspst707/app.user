package com.sea.sistemy.app.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sea.sistemy.app.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {  
    User findByUsername(String username); // Método para encontrar usuário pelo nome de usuário  
}
