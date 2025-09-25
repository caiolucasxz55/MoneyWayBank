package com.fiap.MoneyWayBank.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PixTransactionRequest(
    @NotNull(message = "{transaction.sourceaccount.notnull}")
    Long sourceAccountId,
    
    @NotNull(message = "{transaction.targetaccount.notnull}")
    Long targetAccountId,
    
    @NotNull(message = "{transaction.amount.notnull}")
    @Positive(message = "{transaction.amount.positive}")
    BigDecimal amount
) {}