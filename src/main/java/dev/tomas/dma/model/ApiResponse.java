package dev.tomas.dma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private String message;
    private Instant timestamp;
    private T data;
    private List<String> errors;

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(message, Instant.now(), data, new ArrayList<>());
    }

    public static <T> ApiResponse<T> failure(String message, List<String> errors) {
        return new ApiResponse<>(message,Instant.now(), null, errors);
    }
}
