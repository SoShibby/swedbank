package com.github.soshibby.swedbank.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.soshibby.swedbank.converters.AmountConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henrik on 29/01/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

    private String id;
    @JsonDeserialize(using = AmountConverter.class)
    private Double balance;
    private String name;
    private String accountNumber;
    private String clearingNumber;
    private String fullyFormattedNumber;
    private List<String> availableForTags = new ArrayList<>();
    private boolean isDefault;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getClearingNumber() {
        return clearingNumber;
    }

    public void setClearingNumber(String clearingNumber) {
        this.clearingNumber = clearingNumber;
    }

    public String getFullyFormattedNumber() {
        return fullyFormattedNumber;
    }

    public void setFullyFormattedNumber(String fullyFormattedNumber) {
        this.fullyFormattedNumber = fullyFormattedNumber;
    }

    public List<String> getAvailableForTags() {
        return availableForTags;
    }

    public void setAvailableForTags(List<String> availableForTags) {
        this.availableForTags = availableForTags;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", clearingNumber='" + clearingNumber + '\'' +
                ", fullyFormattedNumber='" + fullyFormattedNumber + '\'' +
                ", availableForTags=" + availableForTags +
                ", isDefault=" + isDefault +
                '}';
    }
}
