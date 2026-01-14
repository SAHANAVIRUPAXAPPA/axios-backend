package com.axios.credit.scoring.model;

import java.math.BigDecimal;

public class ScoreExplanation {

    private final BigDecimal totalCredits;
    private final BigDecimal totalDebits;
    private final BigDecimal netAmount;
    private final int baseScore;
    private final int variableScore;

    public ScoreExplanation(BigDecimal totalCredits,
                            BigDecimal totalDebits,
                            BigDecimal netAmount,
                            int baseScore,
                            int variableScore) {
        this.totalCredits = totalCredits;
        this.totalDebits = totalDebits;
        this.netAmount = netAmount;
        this.baseScore = baseScore;
        this.variableScore = variableScore;
    }

    public BigDecimal getTotalCredits() {
        return totalCredits;
    }

    public BigDecimal getTotalDebits() {
        return totalDebits;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public int getBaseScore() {
        return baseScore;
    }

    public int getVariableScore() {
        return variableScore;
    }
}
