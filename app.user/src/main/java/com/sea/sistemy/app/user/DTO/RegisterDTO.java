package com.sea.sistemy.app.user.DTO;  

import javax.validation.constraints.NotBlank;  

public class RegisterDTO {  

    @NotBlank // Garante que o campo não esteja vazio  
    private String username;  

    @NotBlank // Garante que o campo não esteja vazio  
    private String password;  

    // Getters e Setters  
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
}
