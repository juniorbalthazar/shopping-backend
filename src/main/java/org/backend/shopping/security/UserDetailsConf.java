package org.backend.shopping.security;

import lombok.RequiredArgsConstructor;
import org.backend.shopping.domains.repo.RetryableRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class UserDetailsConf implements ReactiveUserDetailsService {

    private final RetryableRepo repo;
    @Override
    public Mono<UserDetails> findByUsername(String username) {
        var credentials = repo.findByUserName(username);
        var loadedCredentials = Optional.ofNullable(credentials).orElseThrow();
        var user = loadedCredentials.orElse(null);
        assert user != null;
        return Mono.just(new User(user.getUsername(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("USER")))).map(user1 -> user1);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
