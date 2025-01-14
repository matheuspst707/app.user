package com.sea.sistemy.app.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;  

@Entity  
@Table(name = "tb_usuario") // Nome da tabela  
public class User {  

    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID  
    private Long id;  

    @NotBlank // O campo não pode estar vazio  
    private String username;  

    @NotBlank  
    private String password;  

    @NotBlank  
    private String role; // "ROLE_USER" ou "ROLE_ADMIN"  

    public User ( ) {
    	
    }

	public User(Long id, @NotBlank String username, @NotBlank String password, @NotBlank String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}
		
	// Getters e Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
      

	
}  

      
    
  
