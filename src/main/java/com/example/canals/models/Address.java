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
    @Column(name = "id_address")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddress;

    @OneToOne
    @JoinColumn(name = "id_order")
    private Order order;

    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "state", nullable = false)
    private String state;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "residence_num", nullable = false)
    private int residenceNumber;
    @Column(name = "apartment")
    private int apartment;

    public Address(String country, String state, String city, String street, int residenceNumber, int apartment) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.residenceNumber = residenceNumber;
        this.apartment = apartment;
    }
}
