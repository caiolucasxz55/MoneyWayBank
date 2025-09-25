package com.fiap.MoneyWayBank.model;

import com.fiap.MoneyWayBank.types.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account targetAccount;

    @ManyToOne
    private Account sourceAccount;

    @NotNull(message = "{transaction.amount.notnull}")
    @Positive(message = "{transaction.amount.positive}")
    private BigDecimal amount;

    @NotNull(message = "{transaction.date.notnull}")
    @PastOrPresent(message = "{transaction.date.pastorpresent}")
    private LocalDateTime transactionDate;

    @NotNull(message = "{transaction.type.notnull}")
    @Enumerated(EnumType.STRING)
    private TransactionType type;
}
