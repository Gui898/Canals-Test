package com.example.canals.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "warehouse")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Warehouse {

    @Id
    @Column(name = "id_warehouse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWarehouse;

    @Column(name = "name_warehouse", nullable = false)
    private String nameWarehouse;
    @Column(name = "latitude", nullable = false)
    private double latitude;
    @Column(name = "longitude", nullable = false)
    private double longitude;

    @OneToMany(mappedBy = "warehouse")
    private List<Order> ordersList;

    @OneToMany(mappedBy = "warehouse")
    private List<ProdWare> prodWareList;

    public void addOrder(Order order) {
        if (ordersList == null) {
            ordersList = new ArrayList<>();
        }

        if (!ordersList.contains(order)) {
            ordersList.add(order);
        }
    }

}
