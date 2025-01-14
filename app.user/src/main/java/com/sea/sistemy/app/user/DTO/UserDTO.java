package com.sea.sistemy.app.user.DTO;

import com.sea.sistemy.app.user.model.User;

public class UserDTO {
	
	private Long id;
	private String Username;
	
	public UserDTO() {
		
	}
	
	public UserDTO(Long id, String Username) {
		this.id = id;
		this.Username = Username;
		}

	public UserDTO(User user) {
		id = user.getId();
		Username = user.getUsername();
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return Username;
	}

	public void setName(String Username) {
		this.Username = Username;
	}
	
	
	

}
