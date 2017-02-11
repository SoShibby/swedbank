package com.github.soshibby.swedbank.types;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.soshibby.swedbank.converters.AmountConverter;

/**
 * Created by Henrik on 30/01/2017.
 */
public class Balance {

    private String currencyCode;
    @JsonDeserialize(using = AmountConverter.class)
    private Double amount;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
