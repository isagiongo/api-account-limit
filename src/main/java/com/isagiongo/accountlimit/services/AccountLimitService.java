package com.isagiongo.accountlimit.services;

import com.isagiongo.accountlimit.binders.BrokerInput;
import com.isagiongo.accountlimit.models.entities.AccountLimit;
import com.isagiongo.accountlimit.models.requests.AccountLimitRequest;
import com.isagiongo.accountlimit.models.responses.AccountLimitResponse;
import com.isagiongo.accountlimit.repositories.AccountLimitRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountLimitService {

    private final AccountLimitRepository accountLimitRepository;

    @Value("${limit.default.value}")
    private BigDecimal limitValue;

    public AccountLimitService(AccountLimitRepository accountLimitRepository) {
        this.accountLimitRepository = accountLimitRepository;
    }

    public AccountLimitResponse create(AccountLimitRequest accountLimitRequest) {
        AccountLimit accountLimit = new AccountLimit(accountLimitRequest);
        accountLimit.setLimit(limitValue);
        return new AccountLimitResponse(accountLimitRepository.save(accountLimit));
    }

    public Page<AccountLimit> findAll(Pageable pageable) {
        return accountLimitRepository.findAll(pageable);
    }

    @StreamListener(BrokerInput.accountCreated)
    public void accountCreated(AccountLimitRequest request) {
        create(request);
    }
}
