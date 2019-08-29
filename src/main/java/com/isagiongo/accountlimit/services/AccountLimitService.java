package com.isagiongo.accountlimit.services;

import com.isagiongo.accountlimit.model.AccountLimit;
import com.isagiongo.accountlimit.model.request.AccountLimitRequest;
import com.isagiongo.accountlimit.model.response.AccountLimitResponse;
import com.isagiongo.accountlimit.repositories.AccountLimitRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
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
}
