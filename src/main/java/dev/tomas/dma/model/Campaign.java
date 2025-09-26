package dev.tomas.dma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Campaign {
    private Integer id;
    private String name;
    private String description;
}
