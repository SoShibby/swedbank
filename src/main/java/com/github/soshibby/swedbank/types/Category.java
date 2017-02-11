package com.github.soshibby.swedbank.types;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.soshibby.swedbank.converters.AmountConverter;

/**
 * Created by Henrik on 30/01/2017.
 */
public class Category {

    private String id;
    private String name;
    private String group;
    @JsonDeserialize(using = AmountConverter.class)
    private Double amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
