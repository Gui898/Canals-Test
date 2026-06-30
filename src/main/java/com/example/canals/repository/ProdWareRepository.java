package com.example.canals.repository;

import com.example.canals.models.ProdWare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdWareRepository extends JpaRepository<ProdWare, Long> {

    List<ProdWare> findByWarehouseIdWarehouse(Long idWarehouse);
}
