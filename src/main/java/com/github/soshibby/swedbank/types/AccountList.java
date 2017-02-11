package com.github.soshibby.swedbank.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henrik on 29/01/2017.
 * TODO: Add CardCredit. I don't know the properties for the CardCredit object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountList {

    private List<TransactionAccount> transactionAccounts = new ArrayList<>();
    private List<TransactionAccount> transactionDisposalAccounts = new ArrayList<>();
    private List<TransactionAccount> loanAccounts = new ArrayList<>();
    private List<TransactionAccount> savingAccounts = new ArrayList<>();
    private List<TransactionAccount> cardAccounts = new ArrayList<>();

    public List<TransactionAccount> getTransactionAccounts() {
        return transactionAccounts;
    }

    public void setTransactionAccounts(List<TransactionAccount> transactionAccounts) {
        this.transactionAccounts = transactionAccounts;
    }

    public List<TransactionAccount> getTransactionDisposalAccounts() {
        return transactionDisposalAccounts;
    }

    public void setTransactionDisposalAccounts(List<TransactionAccount> transactionDisposalAccounts) {
        this.transactionDisposalAccounts = transactionDisposalAccounts;
    }

    public List<TransactionAccount> getLoanAccounts() {
        return loanAccounts;
    }

    public void setLoanAccounts(List<TransactionAccount> loanAccounts) {
        this.loanAccounts = loanAccounts;
    }

    public List<TransactionAccount> getSavingAccounts() {
        return savingAccounts;
    }

    public void setSavingAccounts(List<TransactionAccount> savingAccounts) {
        this.savingAccounts = savingAccounts;
    }

    public List<TransactionAccount> getCardAccounts() {
        return cardAccounts;
    }

    public void setCardAccounts(List<TransactionAccount> cardAccounts) {
        this.cardAccounts = cardAccounts;
    }

    public List<TransactionAccount> getAllAccounts() {
        List<TransactionAccount> accounts = new ArrayList<>();
        accounts.addAll(transactionAccounts);
        accounts.addAll(transactionDisposalAccounts);
        accounts.addAll(loanAccounts);
        accounts.addAll(savingAccounts);
        accounts.addAll(cardAccounts);
        return accounts;
    }

}
