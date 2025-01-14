package com.sea.sistemy.app.user.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
@Entity  
public class Telefone {  
    
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;  
    @NotNull  
    private String numero;   
    @ManyToOne  
    @JoinColumn(name = "cliente_id", nullable = false)  
    private Cliente cliente;  
    // Getters e Setters  
    public Long getId() {  
        return id;  
    }  
    public void setId(Long id) {  
        this.id = id;  
    }  
    public String getNumero() {  
        return numero;  
    }  
    public void setNumero(String numero) {  
        this.numero = numero;  
    }  
    public Cliente getCliente() {  
        return cliente;  
    }  
    public void setCliente(Cliente cliente) {  
        this.cliente = cliente;  
    }  
}  
