package com.isagiongo.accountlimit.models.responses;

import com.isagiongo.accountlimit.models.entities.AccountLimit;

import java.math.BigDecimal;

public class AccountLimitResponse {

    private String idLimit;

    private BigDecimal limit;

    public AccountLimitResponse(AccountLimit accountLimit) {
        this.idLimit = accountLimit.getIdLimit();
        this.limit = accountLimit.getLimit();
    }

    public String getIdLimit() {
        return idLimit;
    }

    public void setIdLimit(String idLimit) {
        this.idLimit = idLimit;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
