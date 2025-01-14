package com.sea.sistemy.app.user.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sea.sistemy.app.user.model.Cliente;
import com.sea.sistemy.app.user.repositories.ClienteRepository;
@Service  
public class ClienteService {  
    @Autowired  
    private ClienteRepository clienteRepository;  
    public List<Cliente> findAll() {  
        return clienteRepository.findAll();  
    }  
    public Cliente findById(Long id) {  
        return clienteRepository.findById(id).orElse(null);  
    }  
    public Cliente save(Cliente cliente) {  
        return clienteRepository.save(cliente);  
    }  
    public void delete(Long id) {  
        clienteRepository.deleteById(id);  
    }  
    
   
}
