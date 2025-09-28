package dev.tomas.dma.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Campaign {
    private Integer id;

    @NotNull
    @Size(min = 3, max = 100, message = "Name must be at least 3 characters long")
    private String name;

    @NotNull
    @Size(min = 10, max = 2000, message = "Description must be at least 10 characters long")
    private String description;
}
