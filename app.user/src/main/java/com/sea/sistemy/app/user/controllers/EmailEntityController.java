package com.sea.sistemy.app.user.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sea.sistemy.app.user.model.EmailEntity;
import com.sea.sistemy.app.user.service.EmailEntityService;
@RestController  
@RequestMapping("/api/emails")  
public class EmailEntityController {  
    
    @Autowired  
    private EmailEntityService emailService;  
    @GetMapping  
    public List<EmailEntity> getAllEmails() {  
        return emailService.findAll();  // Esse retorno deve ser do tipo List<EmailEntity>  
    }  
    @GetMapping("/{id}")  
    public ResponseEntity<EmailEntity> getEmailById(@PathVariable Long id) {  
        EmailEntity email = emailService.findById(id);  
        return email != null ? ResponseEntity.ok(email) : ResponseEntity.notFound().build();  
    }  
    @PostMapping  
    public EmailEntity createEmail(@RequestBody EmailEntity email) {  
        return emailService.save(email);  // Verifique que o tipo é EmailEntity  
    }  
    @PutMapping("/{id}")  
    public ResponseEntity<EmailEntity> updateEmail(@PathVariable Long id, @RequestBody EmailEntity emailDetails) {  
        EmailEntity email = emailService.findById(id);  
        if (email == null) {  
            return ResponseEntity.notFound().build();  
        }  
        email.setEnderecoEmail(emailDetails.getEnderecoEmail());  
        return ResponseEntity.ok(emailService.save(email)); // Verifique a consistência de tipos  
    }  
    @DeleteMapping("/{id}")  
    public ResponseEntity<Void> deleteEmail(@PathVariable Long id) {  
        emailService.delete(id);  
        return ResponseEntity.noContent().build();  
    }  
}
