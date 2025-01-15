package com.sea.sistemy.app.user.model;  

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sea.sistemy.app.user.DTO.UserRole;

import lombok.EqualsAndHashCode;

@Table(name = "users")
@Entity(name = "users")
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id = UUID.randomUUID().toString();
    private String login;
    private String password;
    private UserRole role;

    public User(String login, String password, UserRole role){
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) {
            return Arrays.asList(
                new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_USER")
            );
        } else {
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    @Override
    public String getPassword() {
        return password;
    }
    public String getId() {
		// TODO Auto-generated method stub
		return id;
	}
    
    public User ( ) {
    	
    }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	public void setRole(Role roleAdmin) {
		// TODO Auto-generated method stub
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}  

      
    
  
