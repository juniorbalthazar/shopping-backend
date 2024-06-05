package org.backend.shopping.domains.repo;


import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import org.backend.shopping.domains.Account;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class RetryableRepo {

    private final AccountRepo accountRepo;

    public RetryableRepo (AccountRepo accountRepo){
        this.accountRepo = accountRepo;
    }


    @Transactional
    @Retryable(retryFor = SQLException.class, maxAttemptsExpression = "#{${retry-database.max-attempts}}", backoff = @Backoff(delayExpression = "#{${retry-database.backoff}}"))
    public Optional<Account> findByUserName(String username){
           return accountRepo.findByusername(username);
    }

}
