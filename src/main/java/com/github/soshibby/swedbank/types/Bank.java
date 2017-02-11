package com.github.soshibby.swedbank.types;

import java.util.List;

/**
 * Created by Henrik on 29/01/2017.
 */
public class Bank {

    private String bankId;
    private String name;
    private PrivateProfile privateProfile;
    private List<CorporateProfile> corporateProfiles;

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PrivateProfile getPrivateProfile() {
        return privateProfile;
    }

    public void setPrivateProfile(PrivateProfile privateProfile) {
        this.privateProfile = privateProfile;
    }

    public List<CorporateProfile> getCorporateProfiles() {
        return corporateProfiles;
    }

    public void setCorporateProfiles(List<CorporateProfile> corporateProfiles) {
        this.corporateProfiles = corporateProfiles;
    }
}
