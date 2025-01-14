package com.sea.sistemy.app.user.DTO;

import com.sea.sistemy.app.user.model.User;

public class UserDTO {  
	  
	private String id;  

	private String username; // Corrigido para 'username' em minúsculas  
	  
	// Construtor padrão  
	public UserDTO() {}  

	// Construtor com parâmetros  
	public UserDTO(String id, String username) {  
		this.id = id;  
		this.username = username; // Corrigido para 'username' em minúsculas  
	}  

	// Construtor a partir de um objeto User  
	public UserDTO(User user) {  
		this.id = user.getId();  
		this.username = user.getUsername(); // Corrigido para 'username' em minúsculas  
	}  

	// Getters e Setters  
	public String getId() {  
		return id;  
	}  

	public void setId(String id) {  
		this.id = id;  
	}  

	public String getUsername() { // Corrigido para 'getUsername' em vez de 'getUserName'  
		return username;  
	}  

	public void setUsername(String username) { // Corrigido para 'setUsername' em vez de 'setName'  
		this.username = username;  
	}  
}
