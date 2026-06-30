package com.example.canals.controller;

import com.example.canals.DTO.OrderRequest;
import com.example.canals.DTO.OrderResponse;
import com.example.canals.models.Order;
import com.example.canals.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody @Valid OrderRequest orderRequest){
        OrderResponse order = orderService.createOrder(orderRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

}
