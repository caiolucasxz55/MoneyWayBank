package com.fiap.MoneyWayBank.model;

import com.fiap.MoneyWayBank.types.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account targetAccount;

    @ManyToOne
    private Account sourceAccount;

    
    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private TransactionType type;
}
