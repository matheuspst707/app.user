package com.sea.sistemy.app.user.security;  

import javax.servlet.FilterChain;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.security.core.context.SecurityContextHolder;  
import org.springframework.security.core.userdetails.UserDetails;  
import org.springframework.security.core.userdetails.UserDetailsService;  
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;  
import org.springframework.web.filter.OncePerRequestFilter;  
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;  


import java.io.IOException;  

public class JwtAuthenticationFilter extends OncePerRequestFilter {  

    @Autowired  
    private TokenService jwtTokenProvider;  

    @Autowired  
    private UserDetailsService userDetailsService;  

    @Override  
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)  
            throws ServletException, IOException {  
        
        String authorizationHeader = request.getHeader("Authorization");  
        String username = null;  
        String jwtToken = null;  

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {  
            jwtToken = authorizationHeader.substring(7); // Remove "Bearer " do início  
            // Extrai o nome de usuário  
            username = jwtTokenProvider.getUsernameFromToken(jwtToken);  
        }  

        // Verifica se o contexto de segurança já está definido  
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {  
            // Validação do token  
            if (jwtToken != null && jwtTokenProvider.validateToken(jwtToken)) {  
                // Authenticate user  
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);  
                UsernamePasswordAuthenticationToken authentication =   
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());  

                // Define os detalhes da autenticação  
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));  
                
                // Define o contexto de segurança  
                SecurityContextHolder.getContext().setAuthentication(authentication);  
            }  
        }  

        filterChain.doFilter(request, response); // Continua a cadeia de filtros  
    }  
} 
