package com.world2meet.superHeroesApi.authentication.service;

import com.world2meet.superHeroesApi.authentication.model.*;
import com.world2meet.superHeroesApi.authentication.repository.UserRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//TODO: Probablemente un Repository
@Service
@AllArgsConstructor
public class AuthServiceAdapter implements AuthServicePort {

    private final UserRepositoryPort userRepository;
    private final JwtServicePort jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=this.userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=this.jwtService.getToken(user);
        return new AuthResponse(token);

    }

    public AuthResponse register(RegisterRequest request) {
        User user = new User(request.getUsername(), this.passwordEncoder.encode(request.getPassword()), Role.USER);
        this.userRepository.register(user);
        return new AuthResponse(this.jwtService.getToken(user));
    }
}
