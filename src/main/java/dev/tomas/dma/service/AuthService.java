package dev.tomas.dma.service;

import dev.tomas.dma.dto.AuthRequest;
import dev.tomas.dma.dto.UserRegisterRequest;
import dev.tomas.dma.model.Company;

public interface AuthService {
    String login(AuthRequest authRequest);
    String register(UserRegisterRequest registerRequest);
    void logout();
}
