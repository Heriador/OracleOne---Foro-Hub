package com.OracleOne.ForoHub.domain.service;

import com.OracleOne.ForoHub.domain.entity.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;

    private static final Long EXPIRATION_MINUTES = 15L;

    public String generateToken(Usuario usuario) {

        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(issuedAt.getTime() + (EXPIRATION_MINUTES * 60 * 1000));
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

        return JWT.create()
                .withIssuer("ForoHub")
                .withSubject(usuario.getEmail())
                .withClaim("id", usuario.getId())
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiration)
                .sign(algorithm);


    }

    public String getSubject(String jwt){

        DecodedJWT verifier = null;

            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            verifier = JWT.require(algorithm)
                    .withIssuer("ForoHub")
                    .build()
                    .verify(jwt);

            verifier.getSubject();


        return verifier.getSubject();
    }
}
