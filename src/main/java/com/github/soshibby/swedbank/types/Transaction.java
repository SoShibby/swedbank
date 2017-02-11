package com.github.soshibby.swedbank.types;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.soshibby.swedbank.converters.AmountConverter;
import com.github.soshibby.swedbank.converters.SwedishDateConverter;
import org.joda.time.DateTime;

/**
 * Created by Henrik on 30/01/2017.
 */
public class Transaction {

    private String id;
    @JsonDeserialize(using = SwedishDateConverter.class)
    private DateTime date;
    private String description;
    private String currency;
    @JsonDeserialize(using = AmountConverter.class)
    private Double amount;
    @JsonDeserialize(using = SwedishDateConverter.class)
    private DateTime accountingDate;
    private Balance accountingBalance;
    private String expenseControlIncluded;
    private Labelings labelings;
    private Categorizations categorizations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public DateTime getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(DateTime accountingDate) {
        this.accountingDate = accountingDate;
    }

    public Balance getAccountingBalance() {
        return accountingBalance;
    }

    public void setAccountingBalance(Balance accountingBalance) {
        this.accountingBalance = accountingBalance;
    }

    public String getExpenseControlIncluded() {
        return expenseControlIncluded;
    }

    public void setExpenseControlIncluded(String expenseControlIncluded) {
        this.expenseControlIncluded = expenseControlIncluded;
    }

    public Labelings getLabelings() {
        return labelings;
    }

    public void setLabelings(Labelings labelings) {
        this.labelings = labelings;
    }

    public Categorizations getCategorizations() {
        return categorizations;
    }

    public void setCategorizations(Categorizations categorizations) {
        this.categorizations = categorizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return amount != null ? amount.equals(that.amount) : that.amount == null;

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
