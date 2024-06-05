package org.backend.shopping.security;

import lombok.RequiredArgsConstructor;
import org.backend.shopping.domains.repo.RetryableRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@RequiredArgsConstructor
class UserDetailsConfig {

   // private final RetryableRepo repo;
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // password=$2a$12$5G8B8WQVf26CDErPSQ4zWOawHkxlbdwBjGNWEPee6AcxDIUk1HTTi
    //site=https://bcrypt-generator.com/
    @Bean
    MapReactiveUserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        //repo.findByUserName()
        var user = User.builder()
                .username("admin")
               // .password(passwordEncoder().encode("password"))
                .password("$2a$12$5G8B8WQVf26CDErPSQ4zWOawHkxlbdwBjGNWEPee6AcxDIUk1HTTi")
                .roles("USER")
                .build();
        return new MapReactiveUserDetailsService(user);
    }



}
