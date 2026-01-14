package com.axios.credit.scoring.engine;

import com.axios.credit.transaction.model.Transaction;
import com.axios.credit.scoring.model.ScoreExplanation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public final class CreditScoringEngine {

    private CreditScoringEngine() {
    }

    public static ScoreResult calculate(List<Transaction> transactions) {

        BigDecimal totalCredits = BigDecimal.ZERO;
        BigDecimal totalDebits = BigDecimal.ZERO;

        if (transactions != null) {
            for (Transaction tx : transactions) {
                if ("CREDIT".equalsIgnoreCase(tx.getTransactionType())) {
                    totalCredits = totalCredits.add(tx.getAmount());
                } else if ("DEBIT".equalsIgnoreCase(tx.getTransactionType())) {
                    totalDebits = totalDebits.add(tx.getAmount());
                }
            }
        }

        BigDecimal netAmount = totalCredits.subtract(totalDebits);

        int baseScore = 500;
        int variableScore = netAmount
                .divide(BigDecimal.valueOf(1000), 0, RoundingMode.DOWN)
                .intValue() * 20;

        int finalScore = baseScore + variableScore;
        finalScore = Math.min(Math.max(finalScore, 300), 900);

        String riskLevel;
        if (finalScore >= 750) {
            riskLevel = "LOW";
        } else if (finalScore >= 600) {
            riskLevel = "MEDIUM";
        } else {
            riskLevel = "HIGH";
        }

        ScoreExplanation explanation =
                new ScoreExplanation(
                        totalCredits,
                        totalDebits,
                        netAmount,
                        baseScore,
                        variableScore
                );

        return new ScoreResult(finalScore, riskLevel, explanation);
    }

    public static record ScoreResult(
            int score,
            String riskLevel,
            ScoreExplanation explanation
    ) {
    }
}
