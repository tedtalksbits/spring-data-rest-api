package com.tedaneblake.ankirestapi.controllers;

import com.tedaneblake.ankirestapi.DTOs.LoginDTO;
import com.tedaneblake.ankirestapi.DTOs.UserDTO;
import com.tedaneblake.ankirestapi.models.AuthenticationResponse;
import com.tedaneblake.ankirestapi.models.LoginRequest;
import com.tedaneblake.ankirestapi.models.RegisterRequest;
import com.tedaneblake.ankirestapi.services.AuthServices;
import com.tedaneblake.ankirestapi.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthServices authServices;

    @Autowired
    public AuthController(AuthServices authServices) {
        this.authServices = authServices;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authServices.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
            return ResponseEntity.ok(authServices.register(request));
    }


}
