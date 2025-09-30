package dev.tomas.dma.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Currency;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data // Getters and setters in 1
@Table(name="campaign")
public class CampaignEntity {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Integer company_id;
    private Currency goal;
}