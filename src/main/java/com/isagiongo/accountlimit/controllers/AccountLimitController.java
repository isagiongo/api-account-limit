package com.isagiongo.accountlimit.controllers;

import com.isagiongo.accountlimit.models.entities.AccountLimit;
import com.isagiongo.accountlimit.models.requests.AccountLimitRequest;
import com.isagiongo.accountlimit.models.responses.AccountLimitResponse;
import com.isagiongo.accountlimit.services.AccountLimitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account-limit")
public class AccountLimitController {

    private final AccountLimitService accountLimitService;

    public AccountLimitController(AccountLimitService accountLimitService) {
        this.accountLimitService = accountLimitService;
    }

    @PostMapping
    public ResponseEntity<AccountLimitResponse> create(@RequestBody AccountLimitRequest accountLimitRequest) {
        return ResponseEntity.ok(accountLimitService.create(accountLimitRequest));
    }

    @GetMapping
    public ResponseEntity<Page<AccountLimit>> findAll(Pageable pageable) {
        return ResponseEntity.ok(accountLimitService.findAll(pageable));
    }
}
