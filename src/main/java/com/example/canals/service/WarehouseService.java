package com.example.canals.service;

import com.example.canals.exceptions.WarehouseNotFoundException;
import com.example.canals.models.*;
import com.example.canals.repository.ProdWareRepository;
import com.example.canals.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final ProdWareRepository prodWareRepository;

    public Warehouse findBestWarehouse(List<OrderProd> listOrderProd, Address address){
        List<Warehouse> listWarehouses = createCandidates(listOrderProd);
        double[] vals = getAddressLatLong(address);

        Warehouse result = null;
        double minDistance = Double.MAX_VALUE;

        for(Warehouse warehouse : listWarehouses){
            double lat = warehouse.getLatitude();
            double lon = warehouse.getLongitude();

            double distance = Math.sqrt(Math.pow((vals[0] - lat), 2) + Math.pow((vals[1] - lon), 2));

            if(distance < minDistance){
                minDistance = distance;
                result = warehouse;
            }
        }

        if(result == null){
            throw new WarehouseNotFoundException("No warehouse can fulfill this order.");
        }

        return result;
    }

    private List<Warehouse> createCandidates(List<OrderProd> listOrderProd){
        List<Warehouse> warehouses = warehouseRepository.findAll();
        List<Warehouse> candidates = new ArrayList<>();

        for(Warehouse ware : warehouses){
            List<ProdWare> prodWares = prodWareRepository
                    .findByWarehouseIdWarehouse(ware.getIdWarehouse());

            boolean verify = true;

            for(OrderProd orderProd : listOrderProd){
                ProdWare stock = prodWares.stream()
                        .filter(prod -> prod.getProduct().getIdProduct()
                                .equals(orderProd.getProduct().getIdProduct()))
                        .findFirst()
                        .orElse(null);

                if(stock == null || stock.getQuantity() < orderProd.getQuantity()){
                    verify = false;
                    break;
                }
            }

            if(verify){
                candidates.add(ware);
            }
        }

        return candidates;
    }

    private double[] getAddressLatLong(Address address){
        if(address.getCity().equals("Tokyo")){
            return new double[] {35.6762, 139.6503};
        } else if (address.getCity().equals("New York")) {
            return new double[] {40.7128, -74.0060};
        }

        return null;
    }

}
