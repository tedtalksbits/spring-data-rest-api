package com.tedaneblake.ankirestapi.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/*
    * This filter will intercept every request and check if the request has a valid JWT token.
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        String jwt;
        String username;

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
        //   if the request does not have header Authorization or a valid JWT token, then the request will be passed to the next filter
            filterChain.doFilter(request, response);
            return;
        }
        //  if the request has a valid JWT token, then the token will be extracted from the header: remove the "Bearer " part which is the first 7 characters
        jwt = authorizationHeader.substring(7);
        username = jwtService.extractUsername(jwt);

        // The SecurityContextHolder is a class that stores the details of the currently authenticated user
        // if the user is not authenticated, then the SecurityContextHolder will be null
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            // if the JWT token is valid, then the user will be authenticated
            if(jwtService.isTokenValid(jwt, userDetails)) {
                // the authToken is needed by the security context to update the SecurityContextHolder
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );
                // The code below is used to set the details of the authenticated user
                // The details are the IP address and the session ID etc.
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                // update the SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        // pass the request to the next filter
        filterChain.doFilter(request, response);

    }
}
