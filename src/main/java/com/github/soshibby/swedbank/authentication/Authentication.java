package com.github.soshibby.swedbank.authentication;

import com.github.soshibby.swedbank.app.App;
import com.github.soshibby.swedbank.exceptions.SwedbankAuthenticationException;
import com.github.soshibby.swedbank.http.SwedbankHttpClient;

import java.util.UUID;

/**
 * Created by Henrik on 29/01/2017.
 */
public abstract class Authentication {

    protected SwedbankHttpClient client;

    public Authentication(App app) {
        String authorizationKey = generateAuthorizationKey(app);
        this.client = new SwedbankHttpClient(authorizationKey, app.getUserAgent());
    }

    public String generateAuthorizationKey(App app) {
        return app.getId() + ":" + UUID.randomUUID().toString().toUpperCase();
    }

    public abstract void authenticate() throws SwedbankAuthenticationException;

    public abstract boolean verify() throws SwedbankAuthenticationException;

    public SwedbankHttpClient getClient() {
        return client;
    }

}
