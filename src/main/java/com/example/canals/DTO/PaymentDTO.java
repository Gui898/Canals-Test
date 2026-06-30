package com.example.canals.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PaymentDTO(
        @NotBlank String cardNumber,
        @NotNull BigDecimal amount,
        String description
) {
}
