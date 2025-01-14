package com.sea.sistemy.app.user.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sea.sistemy.app.user.model.Telefone;
import com.sea.sistemy.app.user.repositories.TelefoneRepository;
@Service  
public class TelefoneService {  
    @Autowired  
    private TelefoneRepository telefoneRepository;  
    public List<Telefone> findAll() {  
        return telefoneRepository.findAll();  
    }  
    public Telefone findById(Long id) {  
        return telefoneRepository.findById(id).orElse(null);  
    }  
    public Telefone save(Telefone telefone) {  
        return telefoneRepository.save(telefone);  
    }  
    public void delete(Long id) {  
        telefoneRepository.deleteById(id);  
    }  
}