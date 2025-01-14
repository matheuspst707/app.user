package com.sea.sistemy.app.user.model;  
import java.util.List;  
import javax.persistence.CascadeType;  
import javax.persistence.Entity;  
import javax.persistence.FetchType;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.OneToMany;  
import javax.persistence.Table;  
import javax.validation.constraints.NotBlank;  
import javax.validation.constraints.NotNull;  
import javax.validation.constraints.Pattern;  
import javax.validation.constraints.Size;  
@Entity  
@Table(name = "tb_cliente")  
public class Cliente {  
    
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private long id;  
    
    @NotBlank(message = "Nome é obrigatório")  
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")  
    @NotNull  
    private String nome;  
    
    @NotBlank(message = "CPF é obrigatório")  
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato XXX.XXX.XXX-XX")  
    @NotNull  
    private String cpf;  
    
    @NotBlank(message = "Endereço é obrigatório")  
    @NotNull  
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
    private List<Endereco> enderecos;  
    
    @NotBlank(message = "Telefone é obrigatório")  
    @NotNull  
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
    private List<Telefone> telefones;  
    
    @NotNull  
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
    private List<EmailEntity> emails;  // Corrigido para usar EmailEntity  
    public Cliente() {  
        
    }  
    
    // Getters e Setters  
    public Long getId() {  
        return id;  
    }  
    public void setId(Long id) {  
        this.id = id;  
    }  
    public String getNome() {  
        return nome;  
    }  
    public void setNome(String nome) {  
        this.nome = nome;  
    }  
    public String getCpf() {  
        return cpf;  
    }  
    public void setCpf(String cpf) {  
        this.cpf = cpf;  
    }  
    public List<Endereco> getEnderecos() {  
        return enderecos;  
    }  
    public void setEnderecos(List<Endereco> enderecos) {  
        this.enderecos = enderecos;  
    }  
    public List<Telefone> getTelefones() {  
        return telefones;  
    }  
    public void setTelefones(List<Telefone> telefones) {  
        this.telefones = telefones;  
    }  
    public List<EmailEntity> getEmails() {  // Corrigido para EmailEntity  
        return emails;  
    }  
    public void setEmails(List<EmailEntity> emails) {  // Corrigido para EmailEntity  
        this.emails = emails;  
    }  
}
