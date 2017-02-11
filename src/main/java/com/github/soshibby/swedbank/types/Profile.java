package com.github.soshibby.swedbank.types;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henrik on 29/01/2017.
 */
public class Profile {

    private String userId;
    private boolean hasSwedbankProfile;
    private boolean hasSavingbankProfile;
    private List<Bank> banks = new ArrayList<>();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean hasSwedbankProfile() {
        return hasSwedbankProfile;
    }

    public void setHasSwedbankProfile(boolean hasSwedbankProfile) {
        this.hasSwedbankProfile = hasSwedbankProfile;
    }

    public boolean hasSavingbankProfile() {
        return hasSavingbankProfile;
    }

    public void setHasSavingbankProfile(boolean hasSavingbankProfile) {
        this.hasSavingbankProfile = hasSavingbankProfile;
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }
}
