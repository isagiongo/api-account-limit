package com.isagiongo.accountlimit.models.entities;

import com.isagiongo.accountlimit.models.requests.AccountLimitRequest;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document
public class AccountLimit {

    @Id
    private String idLimit;

    private String idAccount;

    private BigDecimal limit;

    @CreatedDate
    private LocalDate createdDate;

    @LastModifiedDate
    private LocalDate modifyDate;

    public AccountLimit() { }

    public AccountLimit(AccountLimitRequest accountLimitRequest) {
        this.idAccount = accountLimitRequest.getIdAccount();
    }

    public String getIdLimit() {
        return idLimit;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getModifyDate() {
        return modifyDate;
    }

    public void setIdLimit(String idLimit) {
        this.idLimit = idLimit;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void setModifyDate(LocalDate modifyDate) {
        this.modifyDate = modifyDate;
    }
}
