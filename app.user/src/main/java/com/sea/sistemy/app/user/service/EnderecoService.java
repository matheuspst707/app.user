package com.sea.sistemy.app.user.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sea.sistemy.app.user.model.Endereco;
import com.sea.sistemy.app.user.repositories.EnderecoRepository;
@Service  
public class EnderecoService {  
    @Autowired  
    private EnderecoRepository enderecoRepository;  
    public List<Endereco> findAll() {  
        return enderecoRepository.findAll();  
    }  
    public Endereco findById(Long id) {  
        return enderecoRepository.findById(id).orElse(null);  
    }  
    public Endereco save(Endereco endereco) {  
        return enderecoRepository.save(endereco);  
    }  
    public void delete(Long id) {  
        enderecoRepository.deleteById(id);  
    }  
}
