package com.axios.credit.scoring.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "credit_scores")
public class CreditScore {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private int score;

    @Column(name = "risk_level", nullable = false, length = 20)
    private String riskLevel;

    @Column(name = "generated_at", nullable = false)
    private LocalDateTime generatedAt;

    protected CreditScore() {
        // JPA
    }

    public CreditScore(UUID userId, int score, String riskLevel) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.score = score;
        this.riskLevel = riskLevel;
        this.generatedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public int getScore() {
        return score;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }
}
