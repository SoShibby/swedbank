package com.github.soshibby.swedbank.types;

/**
 * Created by Henrik on 30/01/2017.
 */
public class QuickbalanceSubscription {

    private String id;
    private boolean active;
    private Links links;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
