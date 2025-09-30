package dev.tomas.dma.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "donor")

public class DonorEntity extends UserEntity {
    private String firstName;
    private String lastName;
    private String middleNames;
    private String username;

}
