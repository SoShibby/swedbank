package com.github.soshibby.swedbank.types;

/**
 * Created by Henrik on 29/01/2017.
 */
public class TransactionAccount extends Account {

    private boolean selectedForQuickbalance;
    private String priority;
    private String currency;
    private String originalName;
    private boolean availableForFavouriteAccount;
    private boolean availableForPriorityAccount;
    private boolean favouriteAccount;
    private Links links;
    private DetailLinks details;

    public boolean isSelectedForQuickbalance() {
        return selectedForQuickbalance;
    }

    public void setSelectedForQuickbalance(boolean selectedForQuickbalance) {
        this.selectedForQuickbalance = selectedForQuickbalance;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
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

    public boolean isFavouriteAccount() {
        return favouriteAccount;
    }

    public void setFavouriteAccount(boolean favouriteAccount) {
        this.favouriteAccount = favouriteAccount;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public DetailLinks getDetails() {
        return details;
    }

    public void setDetails(DetailLinks details) {
        this.details = details;
    }
}
