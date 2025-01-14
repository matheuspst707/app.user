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
import com.sea.sistemy.app.user.model.Cliente;
import com.sea.sistemy.app.user.service.ClienteService;
@RestController  
@RequestMapping("/api/clientes")  
public class ClienteController {  
    @Autowired  
    private ClienteService clienteService;  
    @GetMapping  
    public List<Cliente> getAllClientes() {  
        return clienteService.findAll();  
    }  
    @GetMapping("/{id}")  
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {  
        Cliente cliente = clienteService.findById(id); 
        
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();  
    }  
    @PostMapping  
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);  
    }  
    
    @PutMapping("/{id}")  // Adicionando método PUT  
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {  
        Cliente cliente = clienteService.findById(id);  
        
        if (cliente == null) {  
            return ResponseEntity.notFound().build(); // Retorna 404 caso o cliente não seja encontrado  
        }  
        
        // Você pode atualizar os campos necessários aqui  
        cliente.setNome(clienteDetails.getNome());  
        cliente.setEmails(clienteDetails.getEmails());  
        // Adicione outros campos conforme necessário  
        
        Cliente updatedCliente = clienteService.save(cliente); // Salve as alterações  
        return ResponseEntity.ok(updatedCliente); // Retorne o cliente atualizado  
    }
    @DeleteMapping("/{id}")  
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {  
        clienteService.delete(id);  
        return ResponseEntity.noContent().build();  
    }  
}
