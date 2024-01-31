package com.world2meet.superHeroesApi.authentication.service;

import io.jsonwebtoken.Claims;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtServicePort {

    public String getToken(UserDetails user);

    public String getUsernameFromToken(String token);

    boolean isTokenValid(String token, UserDetails userDetails);

    public boolean validateToken(String token, UserDetails user);

    public <T> T getClaim(String token, Function<Claims,T> claimsResolver);



}
