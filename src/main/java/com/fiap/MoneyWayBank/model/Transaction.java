package com.fiap.MoneyWayBank.model;

import com.fiap.MoneyWayBank.types.TransactionType;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
    private Long id;
    private Account targetAccount;
    private Account sourceAccount;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private TransactionType type;
}
