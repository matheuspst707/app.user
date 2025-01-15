package com.sea.sistemy.app.user.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "tb_EmailEntity")
public class EmailEntity {  
    
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;  
    @Email  
    @NotNull  
    private String enderecoEmail; // Exemplo: exemplo@dominio.com  
    @ManyToOne  
    @JoinColumn(name = "cliente_id", nullable = false)  
    private Cliente cliente;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEnderecoEmail() {
		return enderecoEmail;
	}
	public void setEnderecoEmail(String enderecoEmail) {
		this.enderecoEmail = enderecoEmail;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}  
}
