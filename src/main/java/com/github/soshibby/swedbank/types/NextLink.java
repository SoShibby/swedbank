package com.github.soshibby.swedbank.types;

/**
 * Created by Henrik on 29/01/2017.
 */
public class NextLink {

    private String method;
    private String uri;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
