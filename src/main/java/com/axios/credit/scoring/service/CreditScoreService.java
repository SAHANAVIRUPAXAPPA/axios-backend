package com.axios.credit.scoring.service;

import com.axios.credit.scoring.engine.CreditScoringEngine;
import com.axios.credit.scoring.model.CreditScore;
import com.axios.credit.scoring.repository.CreditScoreRepository;
import com.axios.credit.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreditScoreService {

    private final TransactionRepository transactionRepository;
    private final CreditScoreRepository creditScoreRepository;

    public CreditScoreService(TransactionRepository transactionRepository,
                              CreditScoreRepository creditScoreRepository) {
        this.transactionRepository = transactionRepository;
        this.creditScoreRepository = creditScoreRepository;
    }

    // SYSTEM / SCHEDULER
    public CreditScore generate(UUID userId) {
        var transactions = transactionRepository.findByUserId(userId);
        var result = CreditScoringEngine.calculate(transactions);

        CreditScore score =
                new CreditScore(userId, result.score(), result.riskLevel());

        return creditScoreRepository.save(score);
    }

    // USER
    public CreditScore getLatestScore(UUID userId) {
        return creditScoreRepository
                .findTopByUserIdOrderByGeneratedAtDesc(userId)
                .orElseThrow(() ->
                        new IllegalStateException("No credit score found for user"));
    }

    // BANK
    public CreditScoringEngine.ScoreResult explain(UUID userId) {
        var transactions = transactionRepository.findByUserId(userId);
        return CreditScoringEngine.calculate(transactions);
    }
}
