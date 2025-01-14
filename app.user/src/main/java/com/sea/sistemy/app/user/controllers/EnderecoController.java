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
import com.sea.sistemy.app.user.model.Endereco;
import com.sea.sistemy.app.user.service.EnderecoService;
@RestController  
@RequestMapping("/api/enderecos")  
public class EnderecoController {  
    @Autowired  
    private EnderecoService enderecoService;  
    @GetMapping  
    public List<Endereco> getAllEnderecos() {  
        return enderecoService.findAll();  
    }  
    @GetMapping("/{id}")  
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Long id) {  
        Endereco endereco = enderecoService.findById(id);  
        return endereco != null ? ResponseEntity.ok(endereco) : ResponseEntity.notFound().build();  
    }  
    @PostMapping  
    public Endereco createEndereco(@RequestBody Endereco endereco) {  
        return enderecoService.save(endereco);  
    }  
    @PutMapping("/{id}")  
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Long id, @RequestBody Endereco enderecoDetails) {  
        Endereco endereco = enderecoService.findById(id);  
        if (endereco == null) {  
            return ResponseEntity.notFound().build();  
        }  
        endereco.setLogradouro(enderecoDetails.getLogradouro());  
        endereco.setBairro(enderecoDetails.getBairro());  
        endereco.setCidade(enderecoDetails.getCidade());  
        endereco.setUf(enderecoDetails.getUf());  
        endereco.setCep(enderecoDetails.getCep());  
        return ResponseEntity.ok(enderecoService.save(endereco));  
    }  
    @DeleteMapping("/{id}")  
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {  
        enderecoService.delete(id);  
        return ResponseEntity.noContent().build();  
    }  
}
