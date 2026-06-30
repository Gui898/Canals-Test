package com.example.canals.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressDTO(
        @NotBlank String country,
        @NotBlank String state,
        @NotBlank String city,
        @NotBlank String street,
        @Min(1) int residenceNumber,
        int apartment
) {
}
