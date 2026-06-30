package com.example.canals.DTO;

import com.example.canals.models.OrderStatus;

public record OrderResponse(
        Long id,
        String customer,
        OrderStatus status,
        AddressDTO address,
        WarehouseDTO warehouse
        ) {
}
