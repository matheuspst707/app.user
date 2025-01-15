package com.sea.sistemy.app.user.aplication;

import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;  

@SpringBootApplication
@EntityScan(basePackages = "com.sea.sistemy.app.user.model")
public class Aplication {  
    public static void main(String[] args) {  
        SpringApplication.run(Aplication.class, args);  
    }  
}
