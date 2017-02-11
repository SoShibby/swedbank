package com.github.soshibby.swedbank.types;

/**
 * Created by Henrik on 30/01/2017.
 */
public class ExpenseControl {

    private String status;
    private boolean viewCategorizations;
    private Links links;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isViewCategorizations() {
        return viewCategorizations;
    }

    public void setViewCategorizations(boolean viewCategorizations) {
        this.viewCategorizations = viewCategorizations;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
