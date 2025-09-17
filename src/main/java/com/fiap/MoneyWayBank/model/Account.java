package com.fiap.MoneyWayBank.model;

import com.fiap.MoneyWayBank.types.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String agency;
    private String nameHolder;
    private String cpfHolder;
    private LocalDate openingDate;
    private BigDecimal balance;
    private boolean active;

    @Enumerated(EnumType.STRING)
    private AccountType type;

}
