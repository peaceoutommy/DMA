package dev.tomas.dma.service.implementation;

import dev.tomas.dma.dto.UserRegisterRequest;
import dev.tomas.dma.dto.AuthRequest;
import dev.tomas.dma.model.User;
import dev.tomas.dma.model.entity.UserEntity;
import dev.tomas.dma.repository.AuthRepo;
import dev.tomas.dma.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private AuthRepo authRepo;
    private JWTService jwtService;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String login(AuthRequest authRequest) {
        UserEntity user = authRepo.findByUsernameOrEmail(authRequest.getUsername(), authRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtService.generateToken(user.getId());
    }

    @Override
    public String register(UserRegisterRequest registerRequest) {

        if (registerRequest.getEmail() != null && authRepo.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        if (registerRequest.getUsername() != null && authRepo.findByUsername(registerRequest.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        UserEntity entity = new UserEntity();
        entity.setEmail(registerRequest.getEmail());
        entity.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        entity.setPhoneNumber(registerRequest.getPhoneNumber());
        entity.setAddress(registerRequest.getAddress());
        entity.setFirstName(registerRequest.getFirstName());
        entity.setLastName(registerRequest.getLastName());
        entity.setMiddleNames(registerRequest.getMiddleNames());
        entity.setUsername(registerRequest.getUsername());

        var createdUser = authRepo.save(entity);

        return jwtService.generateToken(createdUser.getId());
    }

    @Override
    public void logout() {

    }
}
