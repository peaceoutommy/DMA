package dev.tomas.dma.service.implementation;

import dev.tomas.dma.dto.DonorRegisterRequest;
import dev.tomas.dma.dto.AuthRequest;
import dev.tomas.dma.model.Company;
import dev.tomas.dma.model.Manager;
import dev.tomas.dma.model.entity.DonorEntity;
import dev.tomas.dma.repository.AuthRepo;
import dev.tomas.dma.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private AuthRepo authRepo;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String login(AuthRequest authRequest) {

        return "";
    }

    @Override
    public String registerDonor(DonorRegisterRequest registerRequest) {
        DonorEntity entity = new DonorEntity();
        entity.setEmail(registerRequest.getEmail());
        entity.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        entity.setPhoneNumber(registerRequest.getPhoneNumber());
        entity.setAddress(registerRequest.getAddress());
        entity.setFirstName(registerRequest.getFirstName());
        entity.setLastName(registerRequest.getLastName());
        entity.setMiddleNames(registerRequest.getMiddleNames());
        entity.setUsername(registerRequest.getUsername());

        authRepo.save(entity);

        return "";

        // RETURN JWT

    }

    @Override
    public String registerCompany(Company company) {
        return "";
    }

    @Override
    public String registerManager(Manager manager) {
        return "";
    }

    @Override
    public void logout() {

    }
}
