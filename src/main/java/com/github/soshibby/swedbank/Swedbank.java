package com.github.soshibby.swedbank;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.soshibby.swedbank.authentication.Authentication;
import com.github.soshibby.swedbank.exceptions.SwedbankAuthenticationException;
import com.github.soshibby.swedbank.exceptions.SwedbankServerException;
import com.github.soshibby.swedbank.exceptions.SwedbankUnauthorizedException;
import com.github.soshibby.swedbank.exceptions.SwedbankUserException;
import com.github.soshibby.swedbank.http.SwedbankHttpClient;
import com.github.soshibby.swedbank.types.*;
import com.github.soshibby.swedbank.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Henrik on 29/01/2017.
 */
public class Swedbank {

    private static final Logger log = LoggerFactory.getLogger(Swedbank.class);
    private Authentication authentication;
    private SwedbankHttpClient client;
    private Profile profile;

    public void login(Authentication authentication) throws SwedbankAuthenticationException {
        Assert.notNull(authentication, "Can't login without a authentication method. Authentication object was null.");

        this.authentication = authentication;
        this.authentication.authenticate();
        this.client = this.authentication.getClient();

        Assert.notNull(client, "Expected to get a HttpClient from authentication object. HttpClient was null.");
    }

    public boolean isLoggedIn() throws SwedbankAuthenticationException {
        return authentication != null && authentication.verify();
    }

    public BaseInfo baseInfo() throws SwedbankUnauthorizedException, SwedbankUserException, SwedbankServerException, SwedbankAuthenticationException {
        log.info("Fetching base information from Swedbank.");
        assertIsLoggedIn();
        selectProfile();

        return client.getRequest("transfer/baseinfo", BaseInfo.class);
    }

    public AccountList accountList() throws SwedbankUnauthorizedException, SwedbankUserException, SwedbankServerException, SwedbankAuthenticationException {
        log.info("Fetching list of accounts.");
        assertIsLoggedIn();
        selectProfile();

        return client.getRequest("engagement/overview", AccountList.class);
    }

    public AccountDetails accountDetails(Account account) throws SwedbankUnauthorizedException, SwedbankUserException, SwedbankServerException, SwedbankAuthenticationException {
        log.info("Fetching account details.");
        Assert.notNull(account, "You must specify an account. Account object was null.");
        return accountDetails(account, 100, 1);
    }

    public AccountDetails accountDetails(Account account, int transactionsPerPage, int page) throws SwedbankUnauthorizedException, SwedbankUserException, SwedbankServerException, SwedbankAuthenticationException {
        Assert.notNull(account.getId(), "You must specify an account id.");
        log.info("Fetching account details for account with id {} ({} - {}) on page {}.", account.getId(), account.getName(), account.getFullyFormattedNumber(), page);

        assertIsLoggedIn();
        selectProfile();

        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("transactionsPerPage", transactionsPerPage);
        queryParameters.put("page", page);

        return client.getRequest("engagement/transactions/" + account.getId(), queryParameters, AccountDetails.class);
    }

    private Profile profile() throws SwedbankUnauthorizedException, SwedbankUserException, SwedbankServerException, SwedbankAuthenticationException {
        log.info("Fetching Swedbank profile.");
        assertIsLoggedIn();

        Profile profile = client.getRequest("profile/", Profile.class);

        if (profile.getBanks().size() == 0) {
            log.info("The profile do not contain any bank accounts.");
            throw new SwedbankUserException("The profile do not contain any bank accounts.");
        } else if (!profile.hasSwedbankProfile() && !profile.hasSavingbankProfile()) {
            log.info("The profile do not contain any bank profiles.");
            throw new SwedbankUserException("The profile do not contain any bank profiles.");
        } else {
            return profile;
        }
    }

    private void selectProfile() throws SwedbankUnauthorizedException, SwedbankUserException, SwedbankServerException, SwedbankAuthenticationException {
        if (profile == null) {
            log.info("Selecting Swedbank profile.");
            assertIsLoggedIn();

            profile = profile();
            String profileId = profile.getBanks().get(0).getPrivateProfile().getId();
            log.info("Setting Swedbank profile to {}.", profileId);
            client.postRequest("profile/" + profileId, JsonNode.class);
        }
    }

    private void assertIsLoggedIn() throws SwedbankUnauthorizedException, SwedbankAuthenticationException {
        if (!isLoggedIn()) {
            log.warn("You must be logged in before you can make a request to Swedbank.");
            throw new SwedbankUnauthorizedException("You must be logged in before you can make a request to Swedbank.");
        }
    }

}
