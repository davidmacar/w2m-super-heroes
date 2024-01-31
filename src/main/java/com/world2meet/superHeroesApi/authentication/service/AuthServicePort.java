package com.world2meet.superHeroesApi.authentication.service;

import com.world2meet.superHeroesApi.authentication.model.AuthResponse;
import com.world2meet.superHeroesApi.authentication.model.LoginRequest;
import com.world2meet.superHeroesApi.authentication.model.RegisterRequest;

public interface AuthServicePort {

    public AuthResponse login(LoginRequest loginRequest);

    public AuthResponse register(RegisterRequest registerRequest);

}
