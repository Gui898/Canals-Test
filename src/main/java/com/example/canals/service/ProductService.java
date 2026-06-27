package com.example.canals.service;

import com.example.canals.models.Product;
import com.example.canals.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product getProduct(Long id){
        return productRepository.findById(id).orElseThrow();
    }

}
