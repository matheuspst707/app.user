package com.sea.sistemy.app.user.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Table(name = "tb_Endereco")
public class Endereco {
	@Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;  
    @NotNull  
    private String logradouro;  
    @NotNull  
    private String bairro;  
    @NotNull  
    private String cidade;  
    @NotNull  
    private String uf;  
    @NotNull  
    private String cep;   
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
    public String getLogradouro() {  
        return logradouro;  
    }  
    public void setLogradouro(String logradouro) {  
        this.logradouro = logradouro;  
    }  
    public String getBairro() {  
        return bairro;  
    }  
    public void setBairro(String bairro) {  
        this.bairro = bairro;  
    }  
    public String getCidade() {  
        return cidade;  
    }  
    public void setCidade(String cidade) {  
        this.cidade = cidade;  
    }  
    public String getUf() {  
        return uf;  
    }  
    public void setUf(String uf) {  
        this.uf = uf;  
    }  
    public String getCep() {  
        return cep;  
    }  
    public void setCep(String cep) {  
        this.cep = cep;  
    }  
    public Cliente getCliente() {  
        return cliente;  
    }  
    public void setCliente(Cliente cliente) {  
        this.cliente = cliente;  
    }
}
