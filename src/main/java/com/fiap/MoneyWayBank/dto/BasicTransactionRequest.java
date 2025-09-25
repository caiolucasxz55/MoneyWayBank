package com.fiap.MoneyWayBank.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record BasicTransactionRequest(
    @NotNull(message = "{transaction.targetaccount.notnull}")
    Long accountId,
    
    @NotNull(message = "{transaction.amount.notnull}")
    @Positive(message = "{transaction.amount.positive}")
    BigDecimal amount
) {}