package com.github.soshibby.swedbank;

import com.github.soshibby.swedbank.app.SwedbankApp;
import com.github.soshibby.swedbank.authentication.MobileBankID;
import com.github.soshibby.swedbank.exceptions.SwedbankAuthenticationException;
import com.github.soshibby.swedbank.exceptions.SwedbankServerException;
import com.github.soshibby.swedbank.exceptions.SwedbankUnauthorizedException;
import com.github.soshibby.swedbank.exceptions.SwedbankUserException;
import com.github.soshibby.swedbank.types.Account;
import com.github.soshibby.swedbank.types.AccountDetails;
import com.github.soshibby.swedbank.types.AccountList;
import com.github.soshibby.swedbank.types.BaseInfo;
import com.github.soshibby.swedbank.util.Assert;
import com.github.soshibby.swedbank.utils.Config;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Henrik on 31/01/2017.
 */
public class SwedbankTest {

    private static final Logger log = LoggerFactory.getLogger(SwedbankTest.class);
    private static final Swedbank swedbank = new Swedbank();

    @BeforeClass
    public static void init() throws Exception {
        doLogin();
    }

    @Test
    public void accountList_success() throws SwedbankServerException, SwedbankUnauthorizedException, SwedbankAuthenticationException, SwedbankUserException {
        AccountList accountList = swedbank.accountList();
        Assert.notNull(accountList, "Failed to retrieve account list, account list is null.");
    }

    @Test
    public void accountDetails_success() throws SwedbankServerException, SwedbankUnauthorizedException, SwedbankAuthenticationException, SwedbankUserException {
        AccountList accountList = swedbank.accountList();
        Assert.notNull(accountList, "Failed to retrieve account list, account list is null.");

        Account account = accountList.getTransactionAccounts().get(0);
        Assert.notNull(account, "Failed to get a transaction account, maybe you don't have an transaction account?");

        AccountDetails accountDetails = swedbank.accountDetails(account);
        Assert.notNull(accountDetails, "Failed to retrieve account details, account details is null.");
    }

    @Test
    public void baseInfo_success() throws SwedbankServerException, SwedbankUnauthorizedException, SwedbankAuthenticationException, SwedbankUserException {
        BaseInfo baseInfo = swedbank.baseInfo();
        Assert.notNull(baseInfo, "Failed to retrieve base info, base info is null.");
    }

    private static void doLogin() throws Exception {
        MobileBankID mobileBankID = new MobileBankID(new SwedbankApp(), Config.asString("personalNumber"));
        swedbank.login(mobileBankID);

        int retries = 0;
        while (!swedbank.isLoggedIn()) {
            log.info("Waiting for you to login.");

            if (retries > 20) {
                throw new Exception("Login timeout after 20 retries.");
            }

            Thread.sleep(5000);
            retries++;
        }
    }

}
