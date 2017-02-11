package com.github.soshibby.swedbank.authentication;

import com.github.soshibby.swedbank.app.App;
import com.github.soshibby.swedbank.exceptions.SwedbankAuthenticationException;
import com.github.soshibby.swedbank.types.Login;
import com.github.soshibby.swedbank.types.Verify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Henrik on 29/01/2017.
 */
public class MobileBankID extends Authentication {

    private static final Logger log = LoggerFactory.getLogger(MobileBankID.class);
    private String username;
    private boolean verified;

    public MobileBankID(App app, String username) {
        super(app);
        this.username = username;
    }

    @Override
    public void authenticate() throws SwedbankAuthenticationException {
        verified = false;

        Map<String, Object> data = new HashMap<>();
        data.put("useEasyLogin", false);
        data.put("generateEasyLoginId", false);
        data.put("userId", this.username);

        log.info("Authenticating using Mobile Bank ID.");
        Login login;

        try {
            login = client.postRequest("identification/bankid/mobile", data, Login.class);
        } catch (Exception e) {
            throw new SwedbankAuthenticationException("Failed to authenticate to Swedbank using Mobile Bank ID.", e);
        }

        if (!"USER_SIGN".equals(login.getStatus())) {
            throw new SwedbankAuthenticationException("Unable to use Mobile BankID. Check if the user have enabled Mobile BankID.");
        }
    }

    @Override
    public boolean verify() throws SwedbankAuthenticationException {
        if (verified) {
            return true;
        }

        try {
            Verify verify = client.getRequest("identification/bankid/mobile/verify", Verify.class);
            return verified = "COMPLETE".equals(verify.getStatus());
        } catch (Exception e) {
            throw new SwedbankAuthenticationException("Failed to verify authentication for Mobile Bank ID.", e);
        }
    }

}
