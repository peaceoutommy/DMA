package dev.tomas.dma.service;

import dev.tomas.dma.dto.AuthRequest;
import dev.tomas.dma.dto.DonorRegisterRequest;
import dev.tomas.dma.model.Company;
import dev.tomas.dma.model.Donor;
import dev.tomas.dma.model.Manager;
import org.springframework.stereotype.Service;

public interface AuthService {
    String login(AuthRequest authRequest);
    String registerDonor(DonorRegisterRequest registerRequest);
    String registerCompany(Company company);
    String registerManager(Manager manager);
    void logout();
}
