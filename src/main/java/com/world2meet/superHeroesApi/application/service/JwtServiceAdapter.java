package com.world2meet.superHeroesApi.application.service;

import com.world2meet.superHeroesApi.domain.service.JwtServicePort;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceAdapter implements JwtServicePort {

    private static final String SECRET_KEY="MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAgO27p0zrmK2zlKU/iFzMNYLtfPmPlvc9Ce/S+azTfslUr6yGI75xVp9Whxdir6WmjJ/3o7B5hnqt+tlYWBW16wIDAQABAkAO5WjNB6Ig3dDl18Hja3VcqWfvDJZ+hspSn5bsqf81ortAVG9FzLKMu0Xz2A3k6gxET76BMJ016bKWiMz2iPOhAiEAw+k5S1VjDGbO5bQoJC4X1XIbUvA746nfplvenhCG5bcCIQCoeRs0gn27cFx0GXWb67cop/lBiseJ4CianRtWF8FRbQIhAIGdKMHVkT1gO1wv0Cr3r98QqlE6DXV3KzemKmfLKWSLAiADGadsgfI6Xsj0wfsuEVpffyfREvK1ENDud3GnVeySyQIgPFRQr6GXwbgx88AJ08N+xA+PbDvhXYDV7rp2rfJrRQU=";
    @Override
    public String getToken(UserDetails user) {
        return Jwts
                .builder()
                .setClaims(new HashMap<>())
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*24))
                .signWith(this.getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey() {
        byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String getUsernameFromToken(String token) {
        return this.getClaim(token, Claims::getSubject);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username=this.getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())&& !this.isTokenExpired(token));
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username=getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())&& !this.isTokenExpired(token));
    }

    private boolean isTokenExpired(String token)
    {
        return getExpiration(token).before(new Date());
    }

    private Date getExpiration(String token)
    {
        return getClaim(token, Claims::getExpiration);
    }

    @Override
    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims=getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaims(String token)
    {
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
