package com.github.soshibby.swedbank.types;

import java.util.List;

/**
 * Created by Henrik on 30/01/2017.
 */
public class Labelings {

    private Links links;
    private List<Label> labels;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}
