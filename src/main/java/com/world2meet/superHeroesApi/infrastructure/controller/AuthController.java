package com.world2meet.superHeroesApi.infrastructure.controller;

import com.world2meet.superHeroesApi.domain.model.request.AuthRequest;
import com.world2meet.superHeroesApi.domain.model.response.AuthResponse;
import com.world2meet.superHeroesApi.domain.service.AuthenticatorServicePort;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticatorServicePort authService;
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(this.authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
            return ResponseEntity.ok(this.authService.register(request));
    }

}
