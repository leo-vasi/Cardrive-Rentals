package com.leo.cardriverentals.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private Long addressId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Size(max = 10)
    @Column(name = "num", length = 10)
    private String num;

    @Size(max = 255)
    @Column(name = "street", nullable = false, length = 255)
    private String street;

    @Size(max = 50)
    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Size(max = 50)
    @Column(name = "state", nullable = false, length = 50)
    private String state;

    @Size(max = 50)
    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Size(max = 15)
    @Column(name = "zipcode", nullable = false, length = 15)
    private String zipcode;

    @Size(max = 30)
    @Column(name = "address_type", nullable = false, length = 30)
    private String addressType;
}
