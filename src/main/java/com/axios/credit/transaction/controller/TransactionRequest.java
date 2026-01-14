package com.axios.credit.transaction.controller;

import java.math.BigDecimal;
import java.util.UUID;

public class TransactionRequest {

    private UUID userId;
    private BigDecimal amount;
    private String transactionType;

    public TransactionRequest() {
    }

    public UUID getUserId() {
        return userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }
}
