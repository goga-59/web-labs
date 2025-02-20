package ru.goga59.onlineshop.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(auth -> auth
                    .anyRequest().permitAll())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionManagement -> sessionManagement
                        .maximumSessions(1))
                .formLogin(AbstractHttpConfigurer::disable)
                .build();
    }

    @Bean
    public TomcatConnectorCustomizer tomcatConnectorCustomizer() {
        return connector -> connector.setParseBodyMethods("POST,PATCH,PUT,DELETE");
    }

}
