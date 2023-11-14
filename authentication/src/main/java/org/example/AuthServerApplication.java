package org.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class AuthServerApplication {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}