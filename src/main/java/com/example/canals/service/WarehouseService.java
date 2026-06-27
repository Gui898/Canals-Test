package com.example.canals.service;

import com.example.canals.models.Address;
import com.example.canals.models.OrderProd;
import com.example.canals.models.Warehouse;
import com.example.canals.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private WarehouseRepository warehouseRepository;

    public Warehouse getBestWarehouse(List<OrderProd> listOrderProd){
        /*In process*/
    }

    private double[] getAddressLatLong(Address address){
        if(address.getCountry().equals("Japan")){
            return new double[] {36.2048, 138.2529};
        } else if (address.getCountry().equals("United States")) {
            return new double[] {37.09024, -95.712891};
        }

        return new double[2];
    }

}
