package com.example.canals.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @Column(name = "name_product", nullable = false)
    private String nameProduct;
    @Column(name = "value_product", nullable = false)
    private BigDecimal valueProduct;

    @OneToMany(mappedBy = "product")
    private List<OrderProd> orderProdList;

    @OneToMany(mappedBy = "product")
    private List<ProdWare> prodWareList;
}
