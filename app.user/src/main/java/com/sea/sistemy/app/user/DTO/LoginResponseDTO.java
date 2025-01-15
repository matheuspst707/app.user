package com.sea.sistemy.app.user.DTO;

public class LoginResponseDTO {  

    private final String token;  

    public LoginResponseDTO(String token) {  
        this.token = token;  
    }  

    public String getToken() {  
        return token;  
    }  

    @Override  
    public boolean equals(Object o) {  
        if (this == o) return true; // Verifica se é a mesma instância  
        if (o == null || getClass() != o.getClass()) return false; // Verifica se é do mesmo tipo  
        LoginResponseDTO that = (LoginResponseDTO) o; // Faz o cast  
        return token != null ? token.equals(that.token) : that.token == null; // Compara os tokens  
    }  

    @Override  
    public int hashCode() {  
        return token != null ? token.hashCode() : 0; // Retorna o hash do token  
    }  

    @Override  
    public String toString() {  
        return "LoginResponseDTO{" +  
                "token='" + token + '\'' +  
                '}';  
    }  
}
