package com.world2meet.superHeroesApi.domain.service;

import com.world2meet.superHeroesApi.domain.model.request.AuthRequest;
import com.world2meet.superHeroesApi.domain.model.response.AuthResponse;

public interface AuthenticatorServicePort {
    public AuthResponse login(AuthRequest request);

    AuthResponse register(AuthRequest request);
}
