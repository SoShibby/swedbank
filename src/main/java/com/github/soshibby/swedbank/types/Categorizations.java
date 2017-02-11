package com.github.soshibby.swedbank.types;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henrik on 30/01/2017.
 */
public class Categorizations {

    private List<Category> categories = new ArrayList<>();
    private Links links;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
