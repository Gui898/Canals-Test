package com.example.canals.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "warehouse_prod")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdWare {
    @Id
    @Column(name = "id_warehouse_prod")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProdWare;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_warehouse")
    private  Warehouse warehouse;

    @Column(name = "quantity", nullable = false)
    private int quantity;

}
