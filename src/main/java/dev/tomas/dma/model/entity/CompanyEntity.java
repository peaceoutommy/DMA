package dev.tomas.dma.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class CompanyEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String companyName;
    private String registrationNumber;
    private String taxId;
    
}
