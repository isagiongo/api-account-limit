package com.isagiongo.accountlimit.model;

import com.isagiongo.accountlimit.model.request.AccountLimitRequest;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document
public class AccountLimit {

    @Id
    private String id;

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

    public String getId() {
        return id;
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

    public void setId(String id) {
        this.id = id;
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
