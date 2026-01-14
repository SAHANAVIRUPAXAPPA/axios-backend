package com.axios.credit.transaction.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(name = "transaction_type", nullable = false, length = 20)
    private String transactionType;

    @Column(name = "occurred_at", nullable = false)
    private LocalDateTime occurredAt;

    protected Transaction() {
        // JPA
    }

    public Transaction(UUID userId, BigDecimal amount, String transactionType) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.occurredAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
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

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}
