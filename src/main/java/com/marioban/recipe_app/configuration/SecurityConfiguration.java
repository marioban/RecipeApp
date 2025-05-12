package com.marioban.recipe_app.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {
    public static final String ADMIN_ROLE = "ADMIN";
    public static final String USER_ROLE = "USER";

    @Value("${database.password:password}")
    private String databasePassword;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/**").permitAll()
                        /*
                        .requestMatchers("/mvc/recipe").permitAll()
                        .requestMatchers("/mvc/searchRecipe/**").hasAnyRole(USER_ROLE, ADMIN_ROLE)
                        .requestMatchers("/mvc/saveRecipe","mvc/deleteRecipe","mvc/editRecipe").hasRole(ADMIN_ROLE)
                         */
                )
                .formLogin(withDefaults());
        return http.build();
    }

    public UserDetailsService users() {
        UserDetails user  = User.builder()
                .username("user")
                .password(databasePassword)
                .roles(USER_ROLE)
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(databasePassword)
                .roles(USER_ROLE, ADMIN_ROLE)
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
