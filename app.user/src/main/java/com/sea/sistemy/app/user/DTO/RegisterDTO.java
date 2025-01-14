package com.sea.sistemy.app.user.DTO;

public class RegisterDTO {  

    private final String login;  
    private final String password;  
    private final UserRole role;  

    public RegisterDTO(String login, String password, UserRole role) {  
        this.login = login;  
        this.password = password;  
        this.role = role;  
    }  

    public String getLogin() {  
        return login;  
    }  

    public String getPassword() {  
        return password;  
    }  

    public UserRole getRole() {  
        return role;  
    }  

    @Override  
    public String toString() {  
        return "RegisterDTO{" +  
                "login='" + login + '\'' +  
                ", password='" + password + '\'' +  
                ", role=" + role +  
                '}';  
    }  

    @Override  
    public boolean equals(Object o) {  
        if (this == o) return true;  
        if (!(o instanceof RegisterDTO)) return false;  

        RegisterDTO that = (RegisterDTO) o;  

        if (!login.equals(that.login)) return false;  
        if (!password.equals(that.password)) return false;  
        return role.equals(that.role);  
    }  

    @Override  
    public int hashCode() {  
        int result = login.hashCode();  
        result = 31 * result + password.hashCode();  
        result = 31 * result + role.hashCode();  
        return result;  
    }  
}
