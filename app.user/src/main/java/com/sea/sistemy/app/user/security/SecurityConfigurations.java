package com.sea.sistemy.app.user.security;  

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;  

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
    // @Autowired
    // SecurityFilter securityFilter;

    @Bean  
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {  
        return httpSecurity  
                .csrf().disable()  
                .sessionManagement()  
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)  
                    .and()  
                .authorizeRequests()  
                    .antMatchers(HttpMethod.POST, "/auth/login").permitAll()
                    .antMatchers(HttpMethod.POST, "/auth/register") .permitAll()
                    .antMatchers(HttpMethod.POST, "/cliente").hasRole("ADMIN")
                    .anyRequest().authenticated()  
                    .and()  
                .build();  
    }  

    @Bean  
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {  
        return authenticationConfiguration.getAuthenticationManager();  
    }  

    @Bean  
    public PasswordEncoder passwordEncoder() {  
        return new BCryptPasswordEncoder();  
    }  
}
