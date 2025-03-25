package com.elite.app.auth.security.jwt;


import com.elite.app.auth.security.model.UserAuth;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;


@Slf4j
@Component
public class JwtUtils {

    @Value("${jwt.expiration}")
    private int expirationToken;
    @Value("${jwt.expiration-refresh}")
    private int expirationRefresh;
    @Value("${jwt.secret}")
    private String secret;

    public String getJwtFromHeader(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
//        log.info("Token Received : {}",bearerToken);
        if (bearerToken !=null  && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }

    public String generateTokenForUser(UserAuth userAuth){

        return Jwts.builder()
                .subject(userAuth.getId().toString())
                .claim("username",userAuth.getUsername())
                .claim("email",userAuth.getEmail())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationToken))
                .signWith(key())
                .compact();
    }

    public String generateRefreshTokenForUser(UserAuth userAuth){
        return Jwts.builder()
                .subject(userAuth.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationRefresh))
                .signWith(key())
                .compact();
    }

    public String getUsernameFromJwtToken(String token){

        return Jwts.parser().verifyWith((SecretKey) key())
                .build().parseSignedClaims(token)
                .getPayload().get("username").toString();
    }

    public Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public boolean validateToken(String token){
        try {
//            log.info("validating Token : {}", token);
            Jwts.parser().verifyWith((SecretKey) key())
                    .build().parseSignedClaims(token);

            return true;
        }catch (MalformedJwtException e){
            log.error("Invalid Jwt Token: {}", e.getMessage());
        }catch (ExpiredJwtException e){
            log.error("Jwt Token is Expired: {}",e.getMessage());
        }catch (UnsupportedJwtException e){
            log.error("Jwt Token is unsupported: {}",e.getMessage());
        }catch (IllegalArgumentException e) {
            log.error("Jwt Claims string is empty: {}", e.getMessage());
        }
        return false;

    }

}
