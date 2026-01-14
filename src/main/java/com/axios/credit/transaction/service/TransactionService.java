package com.axios.credit.transaction.service;

import com.axios.credit.transaction.model.Transaction;
import com.axios.credit.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction recordTransaction(UUID userId, BigDecimal amount, String type) {
        Transaction transaction = new Transaction(userId, amount, type);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getUserTransactions(UUID userId) {
        return transactionRepository.findByUserId(userId);
    }
}
