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
import com.sea.sistemy.app.user.model.Telefone;
import com.sea.sistemy.app.user.service.TelefoneService;
@RestController  
@RequestMapping("/api/telefones")  
public class TelefoneController {  
    
    @Autowired  
    private TelefoneService telefoneService;  
    @GetMapping  
    public List<Telefone> getAllTelefones() {  
        return telefoneService.findAll();  
    }  
    @GetMapping("/{id}")  
    public ResponseEntity<Telefone> getTelefoneById(@PathVariable Long id) {  
        Telefone telefone = telefoneService.findById(id);  
        return telefone != null ? ResponseEntity.ok(telefone) : ResponseEntity.notFound().build();  
    }  
    @PostMapping  
    public Telefone createTelefone(@RequestBody Telefone telefone) {  
        return telefoneService.save(telefone);  
    }  
    @PutMapping("/{id}")  
    public ResponseEntity<Telefone> updateTelefone(@PathVariable Long id, @RequestBody Telefone telefoneDetails) {  
        Telefone telefone = telefoneService.findById(id);  
        if (telefone == null) {  
            return ResponseEntity.notFound().build();  
        }  
        telefone.setNumero(telefoneDetails.getNumero());  
        telefone.setCliente(telefoneDetails.getCliente()); // Caso você queira atualizar também o cliente  
        return ResponseEntity.ok(telefoneService.save(telefone));  
    }  
    @DeleteMapping("/{id}")  
    public ResponseEntity<Void> deleteTelefone(@PathVariable Long id) {  
        telefoneService.delete(id);  
        return ResponseEntity.noContent().build();  
    }  
}
