package main.java.cadastrouser.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
  private String secret = "secrete";

  public String genereString(String username){
    return Jwts.builder()
               .setSubject(username)
               .setIssuedAt(new Date())
               .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
               .compact();
  }

  public Claims extractClaims(string token){
    return Jwts.parser()
               .setSigningKey(secret)
               .parseClaimsJws(token)
               .getBody();
  }

  public boolean validateToken(String token, String username){
    return username.equals(extractClaims(token).getSubject()) && !isTokenExpired(token);
  }

  private boolean isTokenExpired(String token){
    return extractClaims(token).getExpiration().before(new Date());
  }
}