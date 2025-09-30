package dev.tomas.dma.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "company")
public class CompanyEntity extends UserEntity {
    private String companyName;
    private String registrationNumber;
    private String taxId;
    
}
