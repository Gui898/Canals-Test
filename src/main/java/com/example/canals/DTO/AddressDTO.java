package com.example.canals.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressDTO(
        @NotNull @NotBlank String country,
        @NotNull @NotBlank String state,
        @NotNull @NotBlank String city,
        @NotNull @NotBlank String street,
        @NotNull int residenceNumber,
        int apartment
) {
}
