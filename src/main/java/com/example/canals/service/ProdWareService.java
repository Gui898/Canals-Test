package com.example.canals.service;

import com.example.canals.models.ProdWare;
import com.example.canals.repository.ProdWareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdWareService {

    private final ProdWareRepository prodWareRepository;

    public List<ProdWare> findProdWareById(Long idWarehouse){
        return prodWareRepository.findByWarehouseId(idWarehouse);
    }

}
