package com.github.soshibby.swedbank.types;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henrik on 29/01/2017.
 */
public class BaseInfo {

    private List<AccountGroup> fromAccountGroup;
    private List<AccountGroup> recipientAccountGroup;
    private List<String> perodicity = new ArrayList<>();
    private RecipientStatus addRecipientStatus;
    private Links links;

    public List<AccountGroup> getFromAccountGroup() {
        return fromAccountGroup;
    }

    public void setFromAccountGroup(List<AccountGroup> fromAccountGroup) {
        this.fromAccountGroup = fromAccountGroup;
    }

    public List<AccountGroup> getRecipientAccountGroup() {
        return recipientAccountGroup;
    }

    public void setRecipientAccountGroup(List<AccountGroup> recipientAccountGroup) {
        this.recipientAccountGroup = recipientAccountGroup;
    }

    public List<String> getPerodicity() {
        return perodicity;
    }

    public void setPerodicity(List<String> perodicity) {
        this.perodicity = perodicity;
    }

    public RecipientStatus getAddRecipientStatus() {
        return addRecipientStatus;
    }

    public void setAddRecipientStatus(RecipientStatus addRecipientStatus) {
        this.addRecipientStatus = addRecipientStatus;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
