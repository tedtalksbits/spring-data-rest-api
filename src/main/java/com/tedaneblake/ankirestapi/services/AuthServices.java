package com.tedaneblake.ankirestapi.services;

import com.tedaneblake.ankirestapi.config.JwtService;
import com.tedaneblake.ankirestapi.exceptions.ObjectNotFoundException;
import com.tedaneblake.ankirestapi.models.*;
import com.tedaneblake.ankirestapi.repositories.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthServices(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService ;
        this.authenticationManager = authenticationManager;

    }
    public AuthenticationResponse login(LoginRequest request, HttpServletResponse response) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken( request.getUsername(), request.getPassword())
        );
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        //  set cookie session here
        ResponseCookie cookie = ResponseCookie.from("token", jwtToken)
                .httpOnly(true)
                .maxAge(60 * 60 * 24 * 30)
                .path("/")
                .build();
        response.addHeader("Set-Cookie", cookie.toString());
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setRole(Role.USER);
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(jwtToken);
    }
}
