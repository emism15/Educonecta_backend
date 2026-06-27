package com.educonecta.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educonecta.dto.LoginRequest;
import com.educonecta.dto.LoginResponse;
import com.educonecta.dto.RegisterRequest;
import com.educonecta.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(
            AuthService authService) {

        this.authService = authService;
    }
    



     @GetMapping("/me")
     public Map<String, Object> me(Authentication authentication){

    Map<String, Object> response = new HashMap<>();

    response.put("username",
            authentication.getName());

    response.put("roles",
            authentication.getAuthorities());

    return response;
}


     @PostMapping("/register-apoderado")
     @PreAuthorize("hasRole('ADMIN')")
     public ResponseEntity<?> registerApoderado(
        @RequestBody RegisterRequest request) {

         authService.register(request);

         return ResponseEntity.ok("Apoderado registrado");
     }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        String token =
                authService.login(request);

        return ResponseEntity.ok(
                new LoginResponse(token));
    }
}