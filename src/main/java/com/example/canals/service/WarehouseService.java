package com.example.canals.service;

import com.example.canals.models.Address;
import com.example.canals.models.OrderProd;
import com.example.canals.models.ProdWare;
import com.example.canals.models.Warehouse;
import com.example.canals.repository.ProdWareRepository;
import com.example.canals.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final ProdWareRepository prodWareRepository;

    public Warehouse getBestWarehouse(List<OrderProd> listOrderProd, Address address){


    }

    private double[] getAddressLatLong(Address address){
        if(address.getCity().equals("Tokyo")){
            return new double[] {35.6762, 139.6503};
        } else if (address.getCity().equals("New York")) {
            return new double[] {40.7128, -74.0060};
        }

        return new double[2];
    }

}
