package com.sea.sistemy.app.user.security;  

import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.security.authentication.AuthenticationManager;  
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;  
import org.springframework.security.config.annotation.web.builders.HttpSecurity;  
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;  
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;  
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;  
import org.springframework.security.crypto.password.PasswordEncoder;  
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;  

@Configuration  
@EnableWebSecurity  
public class SecurityConfig extends WebSecurityConfigurerAdapter {  

    @Override  
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
        auth.inMemoryAuthentication()  
            .withUser("user")  
            .password(passwordEncoder().encode("password"))  
            .roles("USER");  
    }  
    
    @Override  
    protected void configure(HttpSecurity http) throws Exception {  
        http  
            .csrf().disable()  
            .authorizeRequests()  
            .antMatchers("/auth/login").permitAll() // Permita acesso a essa URL  
            .anyRequest().authenticated() // Qualquer outra requisição precisa estar autenticada  
            .and()  
            .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class); // Adiciona o filtro JWT  
    }  

    @Bean  
    @Override  
    public AuthenticationManager authenticationManagerBean() throws Exception {  
        return super.authenticationManagerBean();  
    }  

    @Bean  
    public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {  
        return new JwtAuthenticationFilter();  
    }  
    
    @Bean  
    public PasswordEncoder passwordEncoder() {  
        return new BCryptPasswordEncoder();  
    }  
}
