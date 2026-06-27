package com.example.canals.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_prod")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderProd {

    @Id
    @Column(name = "id_order_prod")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrderProd;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order order;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public OrderProd(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
