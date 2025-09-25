package com.fiap.MoneyWayBank.dto;

import java.math.BigDecimal;

public record PixTransactionRequest(
    Long sourceAccountId,
    Long targetAccountId,
    BigDecimal amount
) {}