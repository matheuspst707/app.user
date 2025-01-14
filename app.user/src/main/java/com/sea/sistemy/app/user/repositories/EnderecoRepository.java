package com.sea.sistemy.app.user.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sea.sistemy.app.user.model.Endereco;
@Repository  
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {  
} 
