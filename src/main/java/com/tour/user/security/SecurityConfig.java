package com.tour.user.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Desactiva CSRF, que es común para APIs REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll()  // Asegúrate de que esto está configurado para permitir acceso a todos
                        .anyRequest().authenticated()  // Cualquier solicitud requiere autenticación
                )
                .httpBasic(withDefaults());  // Configuración de autenticación básica

        return http.build();
    }
}
