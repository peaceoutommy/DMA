package dev.tomas.dma.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class User {
    private Integer id;

    @NotNull
    @Email(message = "Please provide a valid email")
    private String email;

    @NotNull
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must contain upper, lower, number, and special character"
    )
    private String password;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String address;
}
