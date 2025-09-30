package dev.tomas.dma.controller;

import dev.tomas.dma.dto.DonorRegisterRequest;
import dev.tomas.dma.model.entity.DonorEntity;
import dev.tomas.dma.service.AuthService;
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

    @PostMapping
    public String register(@RequestBody @Valid DonorRegisterRequest registerRequest) {
        authService.registerDonor(registerRequest);
        return "success";
    }

}
