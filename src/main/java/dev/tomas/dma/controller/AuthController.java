package dev.tomas.dma.controller;

import dev.tomas.dma.dto.AuthRequest;
import dev.tomas.dma.dto.UserRegisterRequest;
import dev.tomas.dma.service.AuthService;
import dev.tomas.dma.service.implementation.JWTService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;
    private JWTService jwtService;

    @PostMapping("register")
    public String register(@RequestBody @Valid UserRegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @PostMapping("login")
    public String login(@RequestBody @Valid AuthRequest authRequest) {
        return authService.login(authRequest);
    }
}
