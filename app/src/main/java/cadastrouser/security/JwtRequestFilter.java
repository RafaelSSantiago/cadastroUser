package main.java.cadastrouser.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends UsernamePasswordAuthenticationFilter {

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  private UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServeletResponse response, FilterChain chain) throws ServletException, IOException  {
    final String authorizationHeader = request.getHeader("Authorization");

    String userName = null;
    String jwt = null;

    if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
      jwt = authorizationHeader.substring(7);
      userName = jwtUtil.extractClaims(jwt).getSubject();
    }

    if(userName != null && jwtUtil.validateToken(jwt, userName)){

    }

    chain.doFilter(request. response);
  }

}