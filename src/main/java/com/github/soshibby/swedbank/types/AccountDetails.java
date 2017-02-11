package com.github.soshibby.swedbank.types;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henrik on 29/01/2017.
 */
public class AccountDetails {

    private AccountInfo account;
    private List<Transaction> transactions = new ArrayList<>();
    private List<Transaction> reservedTransactions = new ArrayList<>();
    private List<Transaction> bankGiroPrognosisTransactions = new ArrayList<>();
    private boolean numberOfTransactions;
    private boolean numberOfReservedTransactions;
    private boolean numberOfBankGiroPrognosisTransactions;
    private boolean uncategorizedExpenseTransactions;
    private boolean uncategorizedIncomeTransactions;
    private boolean uncategorizedSortOfReceivers;
    private String uncategorizedSubcategoryId;
    private boolean moreTransactionsAvailable;
    private Links links;

    public AccountInfo getAccount() {
        return account;
    }

    public void setAccount(AccountInfo account) {
        this.account = account;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getReservedTransactions() {
        return reservedTransactions;
    }

    public void setReservedTransactions(List<Transaction> reservedTransactions) {
        this.reservedTransactions = reservedTransactions;
    }

    public List<Transaction> getBankGiroPrognosisTransactions() {
        return bankGiroPrognosisTransactions;
    }

    public void setBankGiroPrognosisTransactions(List<Transaction> bankGiroPrognosisTransactions) {
        this.bankGiroPrognosisTransactions = bankGiroPrognosisTransactions;
    }

    public boolean isNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void setNumberOfTransactions(boolean numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }

    public boolean isNumberOfReservedTransactions() {
        return numberOfReservedTransactions;
    }

    public void setNumberOfReservedTransactions(boolean numberOfReservedTransactions) {
        this.numberOfReservedTransactions = numberOfReservedTransactions;
    }

    public boolean isNumberOfBankGiroPrognosisTransactions() {
        return numberOfBankGiroPrognosisTransactions;
    }

    public void setNumberOfBankGiroPrognosisTransactions(boolean numberOfBankGiroPrognosisTransactions) {
        this.numberOfBankGiroPrognosisTransactions = numberOfBankGiroPrognosisTransactions;
    }

    public boolean isUncategorizedExpenseTransactions() {
        return uncategorizedExpenseTransactions;
    }

    public void setUncategorizedExpenseTransactions(boolean uncategorizedExpenseTransactions) {
        this.uncategorizedExpenseTransactions = uncategorizedExpenseTransactions;
    }

    public boolean isUncategorizedIncomeTransactions() {
        return uncategorizedIncomeTransactions;
    }

    public void setUncategorizedIncomeTransactions(boolean uncategorizedIncomeTransactions) {
        this.uncategorizedIncomeTransactions = uncategorizedIncomeTransactions;
    }

    public boolean isUncategorizedSortOfReceivers() {
        return uncategorizedSortOfReceivers;
    }

    public void setUncategorizedSortOfReceivers(boolean uncategorizedSortOfReceivers) {
        this.uncategorizedSortOfReceivers = uncategorizedSortOfReceivers;
    }

    public String getUncategorizedSubcategoryId() {
        return uncategorizedSubcategoryId;
    }

    public void setUncategorizedSubcategoryId(String uncategorizedSubcategoryId) {
        this.uncategorizedSubcategoryId = uncategorizedSubcategoryId;
    }

    public boolean isMoreTransactionsAvailable() {
        return moreTransactionsAvailable;
    }

    public void setMoreTransactionsAvailable(boolean moreTransactionsAvailable) {
        this.moreTransactionsAvailable = moreTransactionsAvailable;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
