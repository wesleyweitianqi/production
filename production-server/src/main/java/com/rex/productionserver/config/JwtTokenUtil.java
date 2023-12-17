package com.rex.productionserver.config;

import io.jsonwebtoken.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtTokenUtil {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(UserDetails userDetails) {
        String username = userDetails.getUsername();
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validate(String authToken, UserDetails userDetails) {
        String username = extractUsername(authToken);
        return username.equals(userDetails.getUsername()) && !isTokenExpirated(authToken);
    }

    private boolean isTokenExpirated(String authToken) {
        Claims claims = null;
        try{
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken).getBody();
            Date expiredDate = claims.getExpiration();
            return expiredDate.before(new Date());
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private Date generateExpireDate(){
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }
}
