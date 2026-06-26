package com.example.canals.service;

import com.example.canals.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;



}
