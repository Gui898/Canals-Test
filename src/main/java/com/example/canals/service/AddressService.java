package com.example.canals.service;

import com.example.canals.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;

}
