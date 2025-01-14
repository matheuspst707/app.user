package com.sea.sistemy.app.user.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sea.sistemy.app.user.model.EmailEntity;
import com.sea.sistemy.app.user.repositories.EmailEntityRepository;
@Service  
public class EmailEntityService {  
    
    @Autowired  
    private EmailEntityRepository emailRepository;  
    public List<EmailEntity> findAll() {  
        return emailRepository.findAll();  // Certifique-se de que retorna EmailEntity  
    }  
    public EmailEntity findById(Long id) {  
        return emailRepository.findById(id).orElse(null); // Verifique se o tipo é EmailEntity  
    }  
    public EmailEntity save(EmailEntity email) {  
        return emailRepository.save(email); // Deve receber EmailEntity  
    }  
    public void delete(Long id) {  
        emailRepository.deleteById(id);  
    }  
}
