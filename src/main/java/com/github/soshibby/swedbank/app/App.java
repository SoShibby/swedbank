package com.github.soshibby.swedbank.app;

/**
 * Created by Henrik on 29/01/2017.
 */
public class App {

    private String id;
    private String userAgent;

    public App(String id, String userAgent) {
        this.id = id;
        this.userAgent = userAgent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

}
