package hw.netology.JDBC_homework.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                .requestMatchers(HttpMethod.GET, "/products/fetch-product").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/hello").permitAll()
                );

        http.sessionManagement(Customizer.withDefaults());
        http.headers(Customizer.withDefaults());
        http.csrf(Customizer.withDefaults());
        http.formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService inMemoryUserDetailsService() {
        User.UserBuilder user = User.builder();
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(user.username("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build());
        userDetailsManager.createUser(user.username("user")
                .password("{noop}user")
                .roles("USER")
                .build());
        return userDetailsManager;
    }
}
