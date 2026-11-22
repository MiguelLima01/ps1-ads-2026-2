package br.edu.fatecfranca.api.services;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.edu.fatecfranca.api.entities.User;

@Service
public class TokenService {

    private static final String ISSUER = "fatecfranca-api";

    private final Algorithm algorithm;

    public TokenService(@Value("${jwt.secret}") String secret) {
        byte[] key = secret.getBytes(StandardCharsets.UTF_8);
        if (key.length < 32) {
            throw new IllegalStateException("JWT_SECRET must contain at least 32 bytes.");
        }
        this.algorithm = Algorithm.HMAC256(key);
    }

    public String generate(User user) {
        Instant issuedAt = Instant.now();
        return JWT.create()
                .withIssuer(ISSUER)
                .withSubject(user.getId().toString())
                .withIssuedAt(issuedAt)
                .withExpiresAt(issuedAt.plus(24, ChronoUnit.HOURS))
                .sign(algorithm);
    }
}
