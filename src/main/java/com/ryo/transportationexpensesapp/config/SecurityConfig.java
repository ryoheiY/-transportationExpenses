package com.ryo.transportationexpensesapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    /**
     * Security設定
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //URLごとの認証設定
        http.authorizeHttpRequests(auth -> auth
                .anyRequest()
                .authenticated()
        );
        //CORS設定
        http.cors(c -> c.configurationSource(corsConfigurationSource()));
        //CSRF設定、RestAPIなので無効
        http.csrf().disable();
        //Oauth設定
        http.oauth2ResourceServer((oauth2) -> oauth2.jwt(jwt -> jwt
                .jwkSetUri("http://localhost:18080/realms/demo/protocol/openid-connect/certs")
        ));

        return http.build();
    }

    /**
     * CORS設定
     *
     * @return
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;

    }
}
