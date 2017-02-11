package com.github.soshibby.swedbank.types;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.soshibby.swedbank.converters.AmountConverter;

/**
 * Created by Henrik on 30/01/2017.
 */
public class AccountInfo extends Account {

    private QuickbalanceSubscription quickbalanceSubscription;
    private boolean currencyAccount;
    @JsonDeserialize(using = AmountConverter.class)
    private Double availableAmount;
    @JsonDeserialize(using = AmountConverter.class)
    private Double creditGranted;
    private boolean internalAccount;
    private String originalName;
    private ExpenseControl expenseControl;
    private boolean availableForFavouriteAccount;
    private boolean availableForPriorityAccount;

    public QuickbalanceSubscription getQuickbalanceSubscription() {
        return quickbalanceSubscription;
    }

    public void setQuickbalanceSubscription(QuickbalanceSubscription quickbalanceSubscription) {
        this.quickbalanceSubscription = quickbalanceSubscription;
    }

    public boolean isCurrencyAccount() {
        return currencyAccount;
    }

    public void setCurrencyAccount(boolean currencyAccount) {
        this.currencyAccount = currencyAccount;
    }

    public Double getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Double availableAmount) {
        this.availableAmount = availableAmount;
    }

    public Double getCreditGranted() {
        return creditGranted;
    }

    public void setCreditGranted(Double creditGranted) {
        this.creditGranted = creditGranted;
    }

    public boolean isInternalAccount() {
        return internalAccount;
    }

    public void setInternalAccount(boolean internalAccount) {
        this.internalAccount = internalAccount;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public ExpenseControl getExpenseControl() {
        return expenseControl;
    }

    public void setExpenseControl(ExpenseControl expenseControl) {
        this.expenseControl = expenseControl;
    }

    public boolean isAvailableForFavouriteAccount() {
        return availableForFavouriteAccount;
    }

    public void setAvailableForFavouriteAccount(boolean availableForFavouriteAccount) {
        this.availableForFavouriteAccount = availableForFavouriteAccount;
    }

    public boolean isAvailableForPriorityAccount() {
        return availableForPriorityAccount;
    }

    public void setAvailableForPriorityAccount(boolean availableForPriorityAccount) {
        this.availableForPriorityAccount = availableForPriorityAccount;
    }
}
