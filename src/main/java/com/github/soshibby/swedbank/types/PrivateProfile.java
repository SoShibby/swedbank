package com.github.soshibby.swedbank.types;

/**
 * Created by Henrik on 29/01/2017.
 */
public class PrivateProfile {

    private String id;
    private String activeProfileLanguage;
    private String bankId;
    private String customerNumber;
    private String bankName;
    private String customerName;
    private Links links;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActiveProfileLanguage() {
        return activeProfileLanguage;
    }

    public void setActiveProfileLanguage(String activeProfileLanguage) {
        this.activeProfileLanguage = activeProfileLanguage;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
