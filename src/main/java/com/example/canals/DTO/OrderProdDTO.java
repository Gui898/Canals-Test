package com.example.canals.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderProdDTO(
        @NotNull @Min(1) Long productId,
        @Min(1) int quantity
) {
}
