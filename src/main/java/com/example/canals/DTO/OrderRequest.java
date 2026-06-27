package com.example.canals.DTO;


import java.util.List;

public record OrderRequest(
         String customer,
         AddressDTO shippingAddress,
         PaymentDTO paymentInfo,
         List<OrderProdDTO> productsList
) {
}
