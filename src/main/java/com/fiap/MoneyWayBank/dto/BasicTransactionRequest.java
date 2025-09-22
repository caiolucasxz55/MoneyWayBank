package com.fiap.MoneyWayBank.dto;

import java.math.BigDecimal;

public record BasicTransactionRequest(
    Long accountId,
    BigDecimal amount
) {}