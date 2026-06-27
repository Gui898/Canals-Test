package com.example.canals.service;

import com.example.canals.DTO.PaymentDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    public boolean processPayment(PaymentDTO request, BigDecimal totalValue){
        return request.amount().compareTo(totalValue) >= 0;
    }

}
