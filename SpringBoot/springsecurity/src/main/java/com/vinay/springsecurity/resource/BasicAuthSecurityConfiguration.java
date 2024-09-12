package com.vinay.springsecurity.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

//@Configuration
@EnableMethodSecurity
public class BasicAuthSecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> {
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.anyRequest()).authenticated();
        });
        //http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf().disable();
        return (SecurityFilterChain)http.build();
    }

    // Create Users
//    @Bean
//    public UserDetailsService userDetailsService(){
//        var user = User.withUsername("Vinay")
//                                .password("{noop}vinayvirat9")
//                                .roles("USER").build();
//
//        var admin = User.withUsername("admin")
//                .password("{noop}admin")
//                .roles("ADMIN").build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        var user = User.withUsername("Vinay")
                .password("vinayvirat9")
                .passwordEncoder(password -> passwordEncoder().encode(password))
                .roles("USER").build();

        var admin = User.withUsername("admin")
                .password("admin")
                .passwordEncoder(password -> passwordEncoder().encode(password))
                .roles("ADMIN").build();
        var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(admin);
        return jdbcUserDetailsManager;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
