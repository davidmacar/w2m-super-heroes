package com.world2meet.superHeroesApi.application.service;

import com.world2meet.superHeroesApi.domain.model.Role;
import com.world2meet.superHeroesApi.domain.model.UserDto;
import com.world2meet.superHeroesApi.domain.model.request.AuthRequest;
import com.world2meet.superHeroesApi.domain.model.response.AuthResponse;
import com.world2meet.superHeroesApi.domain.repository.UserRepositoryPort;
import com.world2meet.superHeroesApi.domain.service.AuthenticatorServicePort;
import com.world2meet.superHeroesApi.domain.service.JwtServicePort;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticatorServiceAdapter implements AuthenticatorServicePort {

    private final UserRepositoryPort userRepository;
    private final JwtServicePort jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(AuthRequest request) {
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=this.userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=this.jwtService.getToken(user);
        return new AuthResponse(token);

    }

    @Override
    public AuthResponse register(AuthRequest request) {
        UserDto user = new UserDto(request.getUsername(), this.passwordEncoder.encode(request.getPassword()), Role.USER);
        this.userRepository.register(user);
        return new AuthResponse(this.jwtService.getToken(user));
    }
}
