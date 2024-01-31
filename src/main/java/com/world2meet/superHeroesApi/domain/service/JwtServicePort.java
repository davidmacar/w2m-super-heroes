package com.world2meet.superHeroesApi.domain.service;

import io.jsonwebtoken.Claims;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtServicePort {
    String getToken(UserDetails user);

    String getUsernameFromToken(String token);

    boolean isTokenValid(String token, UserDetails userDetails);

    boolean validateToken(String token, UserDetails userDetails);

    <T> T getClaim(String token, Function<Claims, T> claimsResolver);
}
