package com.sea.sistemy.app.user.DTO; 

public class AuthenticationDTO {  

    private final String login;  
    private final String password;  

    public AuthenticationDTO(String login, String password) {  
        this.login = login;  
        this.password = password;  
    }  

    public String getLogin() {  
        return login;  
    }  

    public String getPassword() {  
        return password;  
    }  

    @Override  
    public String toString() {  
        return "AuthenticationDTO{" +  
                "login='" + login + '\'' +  
                ", password='" + password + '\'' +  
                '}';  
    }  

    @Override  
    public boolean equals(Object o) {  
        if (this == o) return true;  
        if (!(o instanceof AuthenticationDTO)) return false;  

        AuthenticationDTO that = (AuthenticationDTO) o;  

        if (!login.equals(that.login)) return false;  
        return password.equals(that.password);  
    }  

    @Override  
    public int hashCode() {  
        int result = login.hashCode();  
        result = 31 * result + password.hashCode();  
        return result;  
    }  
} 
