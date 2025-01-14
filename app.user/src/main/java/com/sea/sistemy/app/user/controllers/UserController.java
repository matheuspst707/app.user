package com.sea.sistemy.app.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sea.sistemy.app.user.DTO.UserDTO;
import com.sea.sistemy.app.user.model.User;
import com.sea.sistemy.app.user.service.UserService;

@RestController 
@RequestMapping(value = "users")
public class UserController {  
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/{id}")  
	public UserDTO findById(@PathVariable Long id) {  
	    User user = service.findById(id); // Obtém o User do serviço  
	    return new UserDTO(user); // Converte User para UserDTO  
	}
      
}
