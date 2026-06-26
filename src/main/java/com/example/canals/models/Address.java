package com.example.canals.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAddress;

    private Order order;

    private String country;
    private String state;
    private String city;
    private String street;

    @Column(name = "residence_num")
    private int residenceNumber;
    private int apartment;

}
