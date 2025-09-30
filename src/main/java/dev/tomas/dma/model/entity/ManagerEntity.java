package dev.tomas.dma.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "manager")
public class ManagerEntity extends UserEntity{
    private String firstName;
    private String lastName;
    private String username;
}
