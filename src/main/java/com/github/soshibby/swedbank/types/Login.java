package com.github.soshibby.swedbank.types;

/**
 * Created by Henrik on 29/01/2017.
 */
public class Login {

    private String status;
    private Links links;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
