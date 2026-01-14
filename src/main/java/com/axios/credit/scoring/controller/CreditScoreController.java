package com.axios.credit.scoring.controller;

import com.axios.credit.scoring.engine.CreditScoringEngine;
import com.axios.credit.scoring.model.CreditScore;
import com.axios.credit.scoring.service.CreditScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/score")
public class CreditScoreController {

    private final CreditScoreService service;

    public CreditScoreController(CreditScoreService service) {
        this.service = service;
    }

    // SYSTEM: generate / recompute score
    @PostMapping("/{userId}")
    public CreditScore generate(@PathVariable UUID userId) {
        return service.generate(userId);
    }

    // USER: view latest score
    @GetMapping("/{userId}")
    public CreditScore latest(@PathVariable UUID userId) {
        return service.getLatestScore(userId);
    }

    // BANK: explainable score
    @GetMapping("/explain/{userId}")
    public CreditScoringEngine.ScoreResult explain(@PathVariable UUID userId) {
        return service.explain(userId);
    }
}
