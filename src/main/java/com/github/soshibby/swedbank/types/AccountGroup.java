package com.github.soshibby.swedbank.types;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henrik on 29/01/2017.
 */
public class AccountGroup {

    private String groupId;
    private String name;
    private List<Account> accounts = new ArrayList<>();

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
