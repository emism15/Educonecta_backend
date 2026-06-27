package com.educonecta.segurity;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            CustomUserDetailsService userDetailsService) {

        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }


@Override
protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain)
        throws ServletException, IOException {

    System.out.println("ENTRO AL FILTRO");

    String authHeader =
            request.getHeader("Authorization");

    System.out.println("AUTH HEADER: " + authHeader);

    if(authHeader == null
            || !authHeader.startsWith("Bearer ")) {

        filterChain.doFilter(request,response);
        return;
    }

    String token = authHeader.substring(7);

    System.out.println("TOKEN: " + token);

    String username = jwtService.extractUsername(token);

    System.out.println("USERNAME: " + username);

    if(username != null &&
            SecurityContextHolder.getContext()
                    .getAuthentication() == null){

        UserDetails userDetails =
                userDetailsService
                        .loadUserByUsername(username);

        if(jwtService.isTokenValid(token)){

            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );

            SecurityContextHolder.getContext()
                    .setAuthentication(authToken);

            System.out.println("USUARIO AUTENTICADO");
        }
    }

    filterChain.doFilter(request,response);
}

}
