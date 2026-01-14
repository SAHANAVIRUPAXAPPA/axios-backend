package com.axios.credit.scoring.service;

import com.axios.credit.auth.repository.UserRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CreditScoreScheduler {

    private final CreditScoreService creditScoreService;
    private final UserRepository userRepository;

    public CreditScoreScheduler(CreditScoreService creditScoreService,
                                UserRepository userRepository) {
        this.creditScoreService = creditScoreService;
        this.userRepository = userRepository;
    }

    // Runs every day at 2 AM
    @Scheduled(cron = "0 0 2 * * *")
    public void recomputeAllScores() {
        userRepository.findAll()
                .forEach(user -> creditScoreService.generate(user.getId()));
    }
}
