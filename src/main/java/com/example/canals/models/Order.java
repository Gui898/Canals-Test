package com.example.canals.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Order {

    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;

    @Column(name = "customer")
    private String customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private OrderStatus status = OrderStatus.PENDING_PAYMENT;

    @ManyToOne
    @JoinColumn(name = "id_warehouse")
    private Warehouse warehouse;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProd> productList;

    public Order(String customer, Warehouse warehouse, Address address, List<OrderProd> productList) {
        this.customer = customer;
        this.warehouse = warehouse;
        this.address = address;
        this.productList = productList;
    }

    public void setAddress(Address address) {
        this.address = address;

        if(address != null){
            address.setOrder(this);
        }
    }

    public void setProductList(List<OrderProd> list){
        this.productList = list;

        list.forEach(orderProd -> orderProd.setOrder(this));
    }

    public void setWarehouse(Warehouse warehouse){
        this.warehouse = warehouse;

        if (warehouse != null) {
            warehouse.addOrder(this);
        }
    }
}
