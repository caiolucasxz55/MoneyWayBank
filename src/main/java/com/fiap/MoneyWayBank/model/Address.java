package com.fiap.MoneyWayBank.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    private String zipCode;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
}