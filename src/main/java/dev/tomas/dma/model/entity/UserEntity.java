package dev.tomas.dma.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class UserEntity {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String firstName;
    private String lastName;
    private String middleNames;
    private String username;
}
