package com.fiap.MoneyWayBank.model;

import com.fiap.MoneyWayBank.types.AccountType;
import jakarta.persistence.Entity;
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
    private Long id;
    private String number;
    private String agency;
    private String holderName;
    private String cpfHolder;
    private LocalDate openingDate;
    private BigDecimal balance;
    private boolean active;
    private AccountType type;

}
