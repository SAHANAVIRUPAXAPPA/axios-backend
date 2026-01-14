package com.axios.credit.transaction.controller;

import com.axios.credit.transaction.model.Transaction;
import com.axios.credit.transaction.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody TransactionRequest request) {

        Transaction transaction = transactionService.recordTransaction(
                request.getUserId(),
                request.getAmount(),
                request.getTransactionType()
        );

        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Transaction>> getUserTransactions(@PathVariable UUID userId) {
        return ResponseEntity.ok(transactionService.getUserTransactions(userId));
    }
}
